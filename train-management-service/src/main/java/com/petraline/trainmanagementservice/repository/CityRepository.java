package com.petraline.trainmanagementservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.petraline.trainmanagementservice.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
    
}
