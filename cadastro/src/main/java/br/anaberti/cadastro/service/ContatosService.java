package br.anaberti.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anaberti.cadastro.model.Contatos;
import br.anaberti.cadastro.model.Pessoas;
import br.anaberti.cadastro.repository.ContatosRepository;
import br.anaberti.cadastro.repository.PessoasRepository;

@Service
public class ContatosService {

	@Autowired
	private ContatosRepository contatoRepository;
	
	@Autowired
	private PessoasRepository pessoaRepository;
	
	//POST
	public Contatos save(Contatos contato) {
		//verificar se pessoa existe, caso não, avisar:
		if(contato.getPessoa().getPessoa_id() != null) {
			//buscar pessoa no BD:
			Optional<Pessoas> findPessoa = pessoaRepository.findById(contato.getPessoa().getPessoa_id());
			if(findPessoa.isEmpty()) {
				System.out.println("Pessoa não cadastrada.");
				return null;
			}else {
				contato.setPessoa(findPessoa.get());
				return contatoRepository.save(contato);
		}
		}else {
			System.out.println("Pessoa não cadastrada.");
			return null;
			}
		}
	
	
	//GET - Get from Contatos where pessoa = ?
	public Optional<Contatos> findByPessoa(Long pessoa){
		return contatoRepository.findById(pessoa);
	}
	
	//GET - Get from Contatos where contact_id = ?
	public Optional<Contatos> findById(Long contact_id){
		return contatoRepository.findById(contact_id);
	}
	
	//PUT - UPD - atualizar contato de pessoa
	public Contatos update(Contatos contato) {
		//Pesquisar se a pessoa existe
		Optional<Contatos> findContato = contatoRepository
				.findById(contato.getContact_id());
		//se existir, atualizar:
		if(findContato.isPresent()) {
			//variável auxiliar
			Contatos updContato = findContato.get();
			updContato.setContact(contato.getContact());
			updContato.setContact_type(contato.getcontact_type());
			updContato.setContactNickname(contato.getContactNickname());
			
			//gravar no banco
			return contatoRepository.save(updContato);
		}
		return contatoRepository.save(contato);
	}
	
	//DELETE from Contatos where contact_id = ?
	public void delete(Long contact_id) {
		contatoRepository.deleteById(contact_id);
	}
	
}
