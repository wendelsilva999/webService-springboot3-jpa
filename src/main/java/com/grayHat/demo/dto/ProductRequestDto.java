package com.grayHat.demo.dto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class ProductRequestDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private Double price;
	private String imgUrl; 
	private List<UUID> categoryIds;
	
	public ProductRequestDto() {
    }

	public ProductRequestDto(String name, String description, Double price, String imgUrl, List<UUID> categoryIds) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
		this.categoryIds = categoryIds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<UUID> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<UUID> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
}
