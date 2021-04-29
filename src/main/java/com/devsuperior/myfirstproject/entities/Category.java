package com.devsuperior.myfirstproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id // indicar qual dos campos serão o ID da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indica que esse ID será auto incrementavel no banco
	private Long id;
	private String name;
	
	
	/**
	 * Essa annotation(@JsonIgnore)faz um pré processamento pra dizer que não é para serializar a lista de products de uma categoria
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "category") //é colocado o nome do atributo da outra classe, atributo e não o nome da chave q vai para o banco
	private List<Product> products = new ArrayList<>();
	
	public Category() {
		
	}
	
	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<Product> getProducts() {
		return products;
	}

}
