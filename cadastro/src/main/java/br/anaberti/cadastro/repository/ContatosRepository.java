package br.anaberti.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.anaberti.cadastro.model.Contatos;


@Repository
public interface ContatosRepository extends JpaRepository<Contatos, Long> {

	}

