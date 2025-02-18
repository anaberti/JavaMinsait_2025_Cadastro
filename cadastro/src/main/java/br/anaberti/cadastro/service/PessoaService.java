package br.anaberti.cadastro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anaberti.cadastro.dto.ContatoDTO;
import br.anaberti.cadastro.model.Pessoas;
import br.anaberti.cadastro.repository.PessoasRepository;

@Service
public class PessoaService {

	@Autowired //injeção de dependência
	private PessoasRepository pessoaRepository;
	
	//CRUD - Create
	public Pessoas save(Pessoas pessoa) {
		//regra de negócio:
		//-Se o campo nome está preenchido
		if(pessoa.getFirst_name() == null) {
			System.out.println("Nome da pessoa vazio.");
			return null;
		}
		try {
			return pessoaRepository.save(pessoa);
		}catch (Exception e) {
			System.out.println ("Erro ao cadastrar Pessoa" + pessoa.toString() + ": " + e.getMessage());
			return null;
		}
	}
	
	//CRUD - Read (leitura individual ou lista)
	public Optional<Pessoas> findById(Long pessoa_id){
		//select * from pessoa where id = ?id
		return pessoaRepository.findById(pessoa_id);
	}
	
	public Optional<Pessoas> findByCpf(String cpf){
		if(cpf == null) {
			System.out.println("CPF não encontrado.");
			return null;
		}else {
			//select * from Pessoas where cpf == ?
			return pessoaRepository.findByCpf(cpf);
		}
	}
	
	public List<Pessoas> findAll(){
		//select * from Pessoas
		return pessoaRepository.findAll();
	}
	
	//CRUD - Update
	public Pessoas update(Pessoas pessoa) {
		//Regra de negócio: verificar se o cadastro da pessoa existe; caso sim, atualizar; caso não, inserir.
		
		Optional<Pessoas> findPessoa = pessoaRepository.findById(pessoa.getPessoa_id());
		
		if(findPessoa.isPresent()) {
			Pessoas updPessoa = findPessoa.get();
			updPessoa.setFirst_name(pessoa.getFirst_name());
			updPessoa.setMiddle_name(pessoa.getMiddle_name());
			updPessoa.setLast_name(pessoa.getLast_name());
			updPessoa.setPronoum(pessoa.getPronoum());
			updPessoa.setBirthdate(pessoa.getBirthdate());
			updPessoa.setCpf(pessoa.getCpf());
			updPessoa.setProfession(pessoa.getProfession());
			updPessoa.setAddress(pessoa.getAddress());
			updPessoa.setNumber(pessoa.getNumber());
			updPessoa.setAdditional_address_data(pessoa.getAdditional_address_data());
			updPessoa.setCity(pessoa.getCity());
			updPessoa.setUf(pessoa.getUf());
			updPessoa.setPostal_code(pessoa.getPostal_code());
			
			return pessoaRepository.save(updPessoa); //UPDATE
		}
		
		return pessoaRepository.save(pessoa); //INSERT
	}
	
	//CRUD - Delete
	public void delete(Long pessoa_id) {
		//delete from pessoa where id = ?id
		pessoaRepository.deleteById(pessoa_id);
	}
	
	//DTO
	public List<ContatoDTO> findNameAndAddress() {
		List<Object[]> listResult = pessoaRepository.findNameAndAddress(null);
		List<ContatoDTO> listContatoDTO = new ArrayList<ContatoDTO>();
		
		for(Object[] obj : listResult) {
			ContatoDTO pDTO = returnBDProdutoDTO(obj);
			listContatoDTO.add(pDTO);
		}
		return listContatoDTO;

		}
	
	/**
	 * Conversão de objeto recebido do banco de dados para DTO
	 * @param resultado objeto do BD
	 * @return objeto ContatoDTO
	 */
	private ContatoDTO returnBDProdutoDTO(Object[] resultado) {
		ContatoDTO contatoDTO = new ContatoDTO();
		if(resultado != null) {
			contatoDTO.setId(((Long)resultado[0]).longValue()   );
			contatoDTO.setFirst_name((String)resultado[1]);
			contatoDTO.setLast_name((String)resultado[2]);
			contatoDTO.setAddress((String)resultado[3]);
			contatoDTO.setNumber((String)resultado[4]);
			contatoDTO.setAdditional_address_data((String)resultado[5]);
			contatoDTO.setCity((String)resultado[6]);
			contatoDTO.setUf((String)resultado[7]);
			contatoDTO.setPostal_code((String)resultado[8]);
				
		}
		return contatoDTO;
	}
}


