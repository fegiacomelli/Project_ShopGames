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

import com.fekillershopgames.Fekiller.shop.games.model.Categoria;
import com.fekillershopgames.Fekiller.shop.games.repository.CategoriaRepository;



@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping("/todas")
	public List<Categoria> buscaT(){
		return repository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Categoria> bucasId(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/{descricao}")
	public List <Categoria> buscardescricao(@PathVariable String descricao){
		return repository.findAllByDescricaoContainingIgnoreCase(descricao);
	}
	
	@PostMapping
	public  ResponseEntity<Categoria> addCat(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	@PutMapping
	public ResponseEntity<Categoria> putCat (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	@DeleteMapping("/{id}")
	public void deletar (@PathVariable long id) {
		repository.deleteById(id);
	}

	

}
