package com.petraline.trainmanagementservice.controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import com.petraline.trainmanagementservice.model.City;
import com.petraline.trainmanagementservice.repository.CityRepository;


@Controller
public class CityController {
    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @QueryMapping
    public Iterable<City> cities() {
        return cityRepository.findAll();
    }

    @MutationMapping
    public City addCity(@Argument CityInput city) {
        return cityRepository.save(new City(city.name));
    }

    record CityInput(String name){}
}
