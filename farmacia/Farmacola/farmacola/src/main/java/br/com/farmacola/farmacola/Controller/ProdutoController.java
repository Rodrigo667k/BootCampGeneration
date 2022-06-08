package br.com.farmacola.farmacola.Controller;
//Importando biblioteca apra rodar o c�digo
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.farmacola.farmacola.Model.Produto;
import br.com.farmacola.farmacola.Repository.ProdutoRepository;
@RequestMapping("/produto") //Nome dado para
@RestController // Cria um Controller
@CrossOrigin(origins = "*", allowedHeaders = "*") // Permite conexão com o front-end
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;

	@GetMapping
	public ResponseEntity<List<Produto>> GetAll() {
		return ResponseEntity.ok(repository.findAll()); //Puxar todo o dados da tabela

	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> GetByID(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}//Puxando dados da tabela pelo id

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}////Puxando dados da tabela pelo nome

	@PostMapping
	public ResponseEntity<Produto> post(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}//Postando dados na tabela

	@PutMapping
	public ResponseEntity<Produto> put( @RequestBody Produto produto) {
		return repository.findById(produto.getId()).map(resposta -> ResponseEntity.ok().body(repository.save(produto)))
				.orElse(ResponseEntity.notFound().build());
	}//Mudando dados especificos da tabela caso nao tenha o dado retorna nulo

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePostagem(@PathVariable long id) {
		return repository.findById(id).map(resposta -> {
			repository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
		
	}     //Deletando dados da tabela

}
