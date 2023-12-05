package com.petraline.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.petraline.userservice.model.User;
import java.util.List;



public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByEmail(String email);
}
