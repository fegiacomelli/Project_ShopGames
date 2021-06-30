package com.fekillershopgames.Fekiller.shop.games.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name= "categoria")
public class Categoria {

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotNull
		@Size (min= 1,max = 255)
		private String nome;
		
		@NotNull
		@Size (min= 1,max = 255)
		private String descricao;
		
		
		@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
		@JoinColumn(name = "fk_produto")
		private List<Produto> protudosCriados = new ArrayList<>();


		public List<Produto> getProtudosCriados() {
			return protudosCriados;
		}

		public void setProtudosCriados(List<Produto> protudosCriados) {
			this.protudosCriados = protudosCriados;
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

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
		
		
		
		
		
		
	
	

}
