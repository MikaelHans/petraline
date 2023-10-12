package com.petraline.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petraline.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
