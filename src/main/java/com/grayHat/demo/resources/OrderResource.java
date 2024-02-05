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

import com.grayHat.demo.entities.Order;
import com.grayHat.demo.service.OrderService;

@RestController
@Component
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	
	@PostMapping
	public  ResponseEntity<Order> insert(@RequestBody Order obj){
		obj = service.insert(obj);
		return  ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order>  list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order>findById(@PathVariable UUID id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
}
