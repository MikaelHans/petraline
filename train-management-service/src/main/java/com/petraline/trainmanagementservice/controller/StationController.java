// StationController.java
package com.petraline.trainmanagementservice.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.petraline.trainmanagementservice.model.City;
import com.petraline.trainmanagementservice.model.Station;
import com.petraline.trainmanagementservice.repository.CityRepository;
import com.petraline.trainmanagementservice.repository.StationRepository;

@Controller
public class StationController {

    private final StationRepository stationRepository;
    private final CityRepository cityRepository;

    public StationController(StationRepository stationRepository, CityRepository cityRepository) {
        this.stationRepository = stationRepository;
        this.cityRepository = cityRepository;
    }

    @QueryMapping
    public Iterable<Station> stations() {
        return stationRepository.findAll();
    }

    @MutationMapping
    public Station addStation(@Argument StationInput station) {
        City city = cityRepository.findById(station.stationId).orElseThrow(() -> new IllegalArgumentException());
        return stationRepository.save(new Station(station.name, city));
    }

    record StationInput(String name, long stationId){}
}
