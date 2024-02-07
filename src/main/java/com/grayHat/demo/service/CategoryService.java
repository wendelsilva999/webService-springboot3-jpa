package com.grayHat.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayHat.demo.dto.CategoryWithProductsDto;
import com.grayHat.demo.dto.ProductDto;
import com.grayHat.demo.entities.Category;
import com.grayHat.demo.entities.Product;
//import com.grayHat.demo.entities.Product;
import com.grayHat.demo.repositories.CategoryRepository;
import com.grayHat.demo.repositories.ProductRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository CategoryRepository;

	@Autowired
	private ProductRepository productRepository;

	public Category insert(Category Category) {
		return CategoryRepository.save(Category);
	}

	public List<Category> findAll() {
		return CategoryRepository.findAll();
	}

	public Category findById(UUID id) {
		Optional<Category> obj = CategoryRepository.findById(id);
		return obj.get();

	}


	public CategoryWithProductsDto findByIdWithProducts(UUID id) {
		Optional<Category> optionalCategory = CategoryRepository.findById(id);
		if (optionalCategory.isEmpty()) {
			throw new RuntimeException("Category not found with id: " + id);
		}

		Category category = optionalCategory.get();
		List<Product> products = productRepository.findByCategoryId(id);

		CategoryWithProductsDto categoryWithProductsDto = new CategoryWithProductsDto();
		categoryWithProductsDto.setId(category.getId());
		categoryWithProductsDto.setName(category.getName());

		List<ProductDto> productDtos = products.stream().map(product -> {
			ProductDto productDto = new ProductDto();
			productDto.setId(product.getId());
			productDto.setName(product.getName());
			productDto.setDescription(product.getDescription());
			productDto.setPrice(product.getPrice());
			productDto.setImgUrl(product.getImgUrl());
			return productDto;
		}).collect(Collectors.toList());

		categoryWithProductsDto.setProducts(productDtos);

		return categoryWithProductsDto;
	}

}
