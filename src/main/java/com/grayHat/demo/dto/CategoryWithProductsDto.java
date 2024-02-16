package com.grayHat.demo.dto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class CategoryWithProductsDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private UUID id;
    private String name;
    private List<ProductDto> products;
    
    
	public CategoryWithProductsDto() {
	}

	public CategoryWithProductsDto(UUID id, String name, List<ProductDto> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
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

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}
    
    
    
}
