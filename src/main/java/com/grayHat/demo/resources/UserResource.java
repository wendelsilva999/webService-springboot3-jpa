package com.grayHat.demo.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grayHat.demo.entities.User;
import com.grayHat.demo.service.UserService;

@RestController
@Component
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	
	@PostMapping
	public  ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		return  ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User>  list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
