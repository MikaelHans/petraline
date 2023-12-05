// TrainStopRepository.java
package com.petraline.trainmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petraline.trainmanagementservice.model.TrainStop;

public interface TrainStopRepository extends JpaRepository<TrainStop, Long> {
}
