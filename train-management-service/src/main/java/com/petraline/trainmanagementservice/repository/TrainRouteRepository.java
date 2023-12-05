// TrainRouteRepository.java
package com.petraline.trainmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petraline.trainmanagementservice.model.TrainRoute;

public interface TrainRouteRepository extends JpaRepository<TrainRoute, Long> {
}
