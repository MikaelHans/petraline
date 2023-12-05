// TrainSeatRepository.java
package com.petraline.trainmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petraline.trainmanagementservice.model.TrainSeat;

public interface TrainSeatRepository extends JpaRepository<TrainSeat, Long> {
}
