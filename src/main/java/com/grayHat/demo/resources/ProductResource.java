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

import com.grayHat.demo.dto.ProductRequestDto;
import com.grayHat.demo.entities.Product;
import com.grayHat.demo.service.ProductService;

@RestController
@Component
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	
	@PostMapping("/dto")
	public  ResponseEntity<Product> insert(@RequestBody ProductRequestDto obj){
		Product product = service.insert(obj);
		return  ResponseEntity.ok().body(product);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product>  list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product>findById(@PathVariable UUID id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
}
