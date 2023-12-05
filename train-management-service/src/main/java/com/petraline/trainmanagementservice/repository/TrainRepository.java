package com.petraline.trainmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petraline.trainmanagementservice.model.Train;

public interface TrainRepository extends JpaRepository<Train, Long> {
    
}
