package com.grayHat.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grayHat.demo.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID>{

}
