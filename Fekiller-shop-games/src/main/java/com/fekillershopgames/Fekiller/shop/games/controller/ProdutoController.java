package com.fekillershopgames.Fekiller.shop.games.controller;

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

import com.fekillershopgames.Fekiller.shop.games.model.Produto;
import com.fekillershopgames.Fekiller.shop.games.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping("/todos")
	public List<Produto> buscaP(){
		return repository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Produto> bucasId(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/{nome}")
	public List <Produto> buscarProduto(@PathVariable String nome){
		return repository.findAllByNomeContainingIgnoreCase(nome);
	}
	
	@PostMapping
	public  ResponseEntity<Produto> addProt(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	@PutMapping
	public ResponseEntity<Produto> putCat (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	@DeleteMapping("/{id}")
	public void deletar (@PathVariable long id) {
		repository.deleteById(id);
	}

}
