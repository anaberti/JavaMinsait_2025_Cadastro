package br.anaberti.cadastro.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anaberti.cadastro.model.Contatos;
import br.anaberti.cadastro.service.ContatosService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/contatos") //http://localhost:8080/api/contatos
public class ContatosResource {

	@Autowired
	private ContatosService contatoService;
	
	@PostMapping("/api/contatos") //POST http://localhost:8080/api/contatos
	@Operation(summary = "Grava um novo contato vinculado à uma pessoa cadastrada.")
	public ResponseEntity<Contatos> save(@RequestBody Contatos contato){
		Contatos newContato = contatoService.save(contato);
		if(newContato == null)
			return ResponseEntity.badRequest().build(); //400
		return ResponseEntity.ok(newContato);
	}
	
	@GetMapping("/api/contatos/{contact_id}")
	@Operation (summary = "Localiza um contato através do contact_id.")
	public ResponseEntity<Optional<Contatos>> findById(@PathVariable Long contact_id){
		Optional<Contatos> findContato = contatoService.findById(contact_id);
		if(findContato == null)
			return ResponseEntity.badRequest().build(); //400
		return ResponseEntity.ok(findContato); //200
	}
	
	@GetMapping("/api/contatos/{pessoa}") //GET from Contatos where pessoa (id_pessoa) = ?
	@Operation (summary = "Localiza todos os contatos de uma pessoa através da pessoa_id.")
	public ResponseEntity<Optional<Contatos>> findByPessoa(@PathVariable Long pessoa){
		Optional<Contatos> findContatos = contatoService.findByPessoa(pessoa);
		if(findContatos == null)
			return ResponseEntity.badRequest().build(); //400
		return ResponseEntity.ok(findContatos); //200
	}
		
	@PutMapping("/api/contatos/{contact_id}")
	@Operation (summary = "Atualiza um contato através do contact_id.")
	public ResponseEntity<Contatos> update(@RequestBody Contatos contato){
		Contatos updContato = contatoService.update(contato);
		if(updContato == null)
			return ResponseEntity.badRequest().build(); //400
		return ResponseEntity.ok(updContato); //200
	}
	
	
	//SOLICITADO no projeto: DELETE DO API CONTATOS POR ID
	@DeleteMapping("/api/contatos/{contact_id}")
	@Operation (summary = "Apaga um contato através do contact_id.")
	public ResponseEntity<?> delete(@PathVariable Long contact_id){
		contatoService.delete(contact_id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
	}
	
}
