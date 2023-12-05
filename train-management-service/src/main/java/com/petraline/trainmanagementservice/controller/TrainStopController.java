// TrainStopController.java
package com.petraline.trainmanagementservice.controller;

import java.time.LocalDateTime;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.petraline.trainmanagementservice.model.Station;
import com.petraline.trainmanagementservice.model.TrainStop;
import com.petraline.trainmanagementservice.repository.TrainStopRepository;

@Controller
public class TrainStopController {

    private final TrainStopRepository trainStopRepository;

    public TrainStopController(TrainStopRepository trainStopRepository) {
        this.trainStopRepository = trainStopRepository;
    }

    @QueryMapping
    public Iterable<TrainStop> trainStops() {
        return trainStopRepository.findAll();
    }

    @MutationMapping
    public TrainStop addTrainStop(@Argument TrainStopInput trainStopInput) {
        TrainStop newTrainStop = new TrainStop(trainStopInput.stopNumber, trainStopInput.station, trainStopInput.prevStop, trainStopInput.nexStop, trainStopInput.arrival, trainStopInput.departure);
        return trainStopRepository.save(newTrainStop);
    }

    record TrainStopInput(int stopNumber, Station station, TrainStop prevStop, TrainStop nexStop, LocalDateTime arrival, LocalDateTime departure) {}
}
