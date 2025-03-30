package com.grayHat.demo.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable=false)
	private String name;
	
	@ManyToMany(mappedBy = "categories")
	@JsonBackReference
	private Set<Product> products = new HashSet<>();
	
	public Category() {
	}

	public Category(UUID id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public Set<Product> getProducts() {
		return products;
	}
	
	

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", products=" + products + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getProducts()=" + getProducts() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
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
	
	
}
