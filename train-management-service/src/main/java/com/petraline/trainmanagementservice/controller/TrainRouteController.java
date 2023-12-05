// TrainRouteController.java
package com.petraline.trainmanagementservice.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.petraline.trainmanagementservice.model.Station;
import com.petraline.trainmanagementservice.model.Train;
import com.petraline.trainmanagementservice.model.TrainRoute;
import com.petraline.trainmanagementservice.repository.TrainRouteRepository;

@Controller
public class TrainRouteController {

    private final TrainRouteRepository trainRouteRepository;

    public TrainRouteController(TrainRouteRepository trainRouteRepository) {
        this.trainRouteRepository = trainRouteRepository;
    }

    @QueryMapping
    public Iterable<TrainRoute> trainRoutes() {
        return trainRouteRepository.findAll();
    }

    @MutationMapping
    public TrainRoute addTrainRoute(@Argument TrainRouteInput trainRoute) {
        return trainRouteRepository.save(new TrainRoute(trainRoute.train, trainRoute.startStation, trainRoute.endStation));
    }

    record TrainRouteInput(Train train, Station startStation, Station endStation){}
}
