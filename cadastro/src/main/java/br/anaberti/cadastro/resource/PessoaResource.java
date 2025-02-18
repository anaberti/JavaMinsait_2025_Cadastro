package br.anaberti.cadastro.resource;

import java.util.Optional;
import java.util.List;

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

import br.anaberti.cadastro.dto.ContatoDTO;
import br.anaberti.cadastro.model.Pessoas;
import br.anaberti.cadastro.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/pessoas") //http://localhost:8080/api/pessoas
public class PessoaResource {
	
	@Autowired
	PessoaService pessoaService;
	
	@Operation (summary = "Salva o registro de nova pessoa.")
	@PostMapping ("/api/pessoas")
	public ResponseEntity<Pessoas> save(@RequestBody Pessoas pessoa) {
		Pessoas newPessoa = pessoaService.save(pessoa);
		if(newPessoa == null) {
			return ResponseEntity.badRequest().build(); //status code 400
			} else {
				return ResponseEntity.ok(newPessoa); //status code 200 e retorna objeto
				}
	}

	@Operation (summary = "Localiza pessoa através do CPF.")
	@GetMapping("/api/pessoas/cpf/{cpf}") 
	public ResponseEntity<Optional<Pessoas>>findByCpf(
			@PathVariable String cpf){
		Optional<Pessoas> pessoa = pessoaService.findByCpf(cpf);
		if (pessoa.isEmpty()) {
			return ResponseEntity.notFound().build(); //404
		}else {
			return ResponseEntity.ok(pessoa); //200
		}
	}
	
	@Operation (summary = "Localiza pessoa através da pessoa_id.")
	@GetMapping("/api/pessoas/pessoa_id/{pessoa_id}") 
	public ResponseEntity<Optional<Pessoas>>findById(
			@PathVariable Long pessoa_id){
		Optional<Pessoas> pessoa = pessoaService.findById(pessoa_id);
		if (pessoa.isEmpty()) {
			return ResponseEntity.notFound().build(); //404
		}else {
			return ResponseEntity.ok(pessoa); //200
		}
	}
	
	@Operation (summary = "Lista todas as pessoas cadastradas.")
	@GetMapping("/api/pessoas") 
	public ResponseEntity<List<Pessoas>> findAll(){
		List<Pessoas> pessoas = pessoaService.findAll();
		if(pessoas == null)
			return ResponseEntity.badRequest().build();
		if(pessoas.size() == 0)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoas);
	}
	
	@Operation (summary = "Atualiza o cadastro da pessoa através da pessoa_id.")
	@PutMapping("/api/pessoas/{pessoa_id}")
	public ResponseEntity<Pessoas> update(@RequestBody Pessoas pessoa){
		Pessoas updPessoa = pessoaService.update(pessoa);
		if(updPessoa == null) {
			return ResponseEntity.badRequest().build(); //status 400
		}else {
			return ResponseEntity.ok(updPessoa); //status 200 e retorna objeto
		}
	}
	
	@Operation (summary = "Apaga o cadastro da pessoa através da pessoa_id.")
	@DeleteMapping("api/pessoas/{pessoa_id}") //DELETE http://localhost:8080/api/pessoas/1
	public ResponseEntity<?> delete(@PathVariable Long id){
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
	}
	
	@GetMapping("/api/pessoas/maladireta/{pessoa_id}")
	@Operation (summary = "Apresenta os dados de uma pessoa para endereçar mala direta através do pessoa_id")
	public ResponseEntity<List<ContatoDTO>> findNameAndAddress(){
		List<ContatoDTO> pessoaDtos = pessoaService.findNameAndAddress();
			if(pessoaDtos == null) {
				return ResponseEntity.notFound().build();				
			}
			if(pessoaDtos.size() == 0) {
				return ResponseEntity.notFound().build();				
			}
			return ResponseEntity.ok(pessoaDtos);
		
	}
	
}
