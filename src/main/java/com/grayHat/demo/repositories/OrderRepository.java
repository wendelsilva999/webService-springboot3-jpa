package com.grayHat.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grayHat.demo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, UUID>{

}
