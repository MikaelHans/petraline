// TrainClassRepository.java
package com.petraline.trainmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petraline.trainmanagementservice.model.TrainClass;

public interface TrainClassRepository extends JpaRepository<TrainClass, Long> {
}
