package com.fekillershopgames.Fekiller.shop.games.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name= "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size (min= 1,max = 255)
	private String nome;
	
	@NotNull
	@Size (min= 1,max = 255)
	private  String plataforma;
	
	@NotNull
	private  Float preco;
	
	
	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_categoria")
	private Categoria estilo;

	public Categoria getCriada() {
		return estilo;
	}

	public void setCriada(Categoria criada) {
		this.estilo = criada;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	} 

	
	
}
