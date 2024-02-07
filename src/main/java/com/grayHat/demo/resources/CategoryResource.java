package com.grayHat.demo.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grayHat.demo.dto.CategoryWithProductsDto;
import com.grayHat.demo.entities.Category;
//import com.grayHat.demo.entities.Product;
import com.grayHat.demo.service.CategoryService;

@RestController
@Component
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;

	@PostMapping
	public ResponseEntity<Category> insert(@RequestBody Category obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable UUID id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

	@GetMapping(value = "/categoryAllProducts/{categoryId}")
	public ResponseEntity<CategoryWithProductsDto> findAllProductsByCategoryId(@PathVariable UUID categoryId) {
	    CategoryWithProductsDto categoryWithProducts = service.findByIdWithProducts(categoryId);
	    return ResponseEntity.ok().body(categoryWithProducts);
	}


}
