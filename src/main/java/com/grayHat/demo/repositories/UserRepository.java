package com.grayHat.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grayHat.demo.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, UUID>{
    UserDetails findByUsername(String username);
}
