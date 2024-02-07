package com.grayHat.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grayHat.demo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
	@Query("SELECT c FROM Category c LEFT JOIN FETCH c.products WHERE c.id = :id")
	Category findByIdWithProducts(@Param("id") UUID id);
}
