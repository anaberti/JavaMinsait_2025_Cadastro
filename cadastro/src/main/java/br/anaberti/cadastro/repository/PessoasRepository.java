package br.anaberti.cadastro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.anaberti.cadastro.model.Pessoas;

@Repository
public interface PessoasRepository extends JpaRepository<Pessoas, Long> {

	Optional<Pessoas> findByCpf(String cpf);

	@Query(value = 	
		"SELECT "
			+ "tb_pessoas.pessoa_id,"
			+ "tb_pessoas.first_name, "
			+ "tb_pessoas.last_name, "
			+ "tb_pessoas.address, "
			+ "tb_pessoas.number, "
			+ "tb_pessoas.additional_address_data, "
			+ "tb_pessoas.city, "
			+ "tb_pessoas.uf, "
			+ "tb_pessoas.postal_code "
		+ "FROM tb_pessoas "
		+ "WHERE tb_pessoas.pessoa_id equals ?1", nativeQuery = true)	
	List<Object[]> findNameAndAddress(Long pessoa_id);

	}
