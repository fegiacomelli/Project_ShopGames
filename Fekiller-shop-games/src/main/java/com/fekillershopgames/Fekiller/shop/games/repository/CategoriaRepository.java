package com.fekillershopgames.Fekiller.shop.games.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fekillershopgames.Fekiller.shop.games.model.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	public  List<Categoria> findAllByNomeContainingIgnoreCase(String nome);

	public Optional<Categoria> findById(Long id);
	
	public  List<Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);
	
	
	

}
