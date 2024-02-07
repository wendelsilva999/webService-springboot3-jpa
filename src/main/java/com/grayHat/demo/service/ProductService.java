package com.grayHat.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayHat.demo.dto.ProductRequestDto;
import com.grayHat.demo.entities.Category;
import com.grayHat.demo.entities.Product;
import com.grayHat.demo.repositories.CategoryRepository;
import com.grayHat.demo.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository ProductRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Product insert (ProductRequestDto requestDto) {
		Product product = new Product();
		product.setName(requestDto.getName());
		product.setDescription(requestDto.getDescription());
		product.setPrice(requestDto.getPrice());
		product.setImgUrl(requestDto.getImgUrl());
		
		List<Category> categories = new ArrayList<>();
		for (UUID categoryId : requestDto.getCategoryIds()) {
			Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
			if(categoryOptional.isPresent()) {
				categories.add(categoryOptional.get());
			}
		}
		
		product.setCategories(new HashSet<>(categories));
		
		return ProductRepository.save(product);
	}
	
	public List<Product> findAll(){
		return ProductRepository.findAll();
	}
	
	public Product findById(UUID id) {
		Optional<Product> obj = ProductRepository.findById(id);
		return obj.get();
		
	}
}
