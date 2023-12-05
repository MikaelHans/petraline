// StationRepository.java
package com.petraline.trainmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petraline.trainmanagementservice.model.Station;

public interface StationRepository extends JpaRepository<Station, Long> {
}
