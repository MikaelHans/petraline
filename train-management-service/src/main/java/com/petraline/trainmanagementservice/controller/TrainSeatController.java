// TrainSeatController.java
package com.petraline.trainmanagementservice.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.petraline.trainmanagementservice.model.Train;
import com.petraline.trainmanagementservice.model.TrainClass;
import com.petraline.trainmanagementservice.model.TrainSeat;
import com.petraline.trainmanagementservice.repository.TrainSeatRepository;

@Controller
public class TrainSeatController {

    private final TrainSeatRepository trainSeatRepository;

    public TrainSeatController(TrainSeatRepository trainSeatRepository) {
        this.trainSeatRepository = trainSeatRepository;
    }

    @QueryMapping
    public Iterable<TrainSeat> trainSeats() {
        return trainSeatRepository.findAll();
    }

    @MutationMapping
    public TrainSeat addTrainSeat(@Argument TrainSeatInput trainSeat) {
        return trainSeatRepository.save(new TrainSeat(trainSeat.rowNumber, trainSeat.col, trainSeat.trainClass));
    }

    record TrainSeatInput(int rowNumber, char col, TrainClass trainClass){}
}
