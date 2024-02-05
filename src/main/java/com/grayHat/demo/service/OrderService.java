package com.grayHat.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayHat.demo.entities.Order;
import com.grayHat.demo.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository OrderRepository;
	
	public Order insert (Order Order) {
		return OrderRepository.save(Order);
	}
	
	public List<Order> findAll(){
		return OrderRepository.findAll();
	}
	
	public Order findById(UUID id) {
		Optional<Order> obj = OrderRepository.findById(id);
		return obj.get();
		
	}
}
