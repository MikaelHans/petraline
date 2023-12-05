package com.petraline.trainmanagementservice.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.petraline.trainmanagementservice.model.Train;
import com.petraline.trainmanagementservice.model.Trainline;
import com.petraline.trainmanagementservice.repository.TrainRepository;
import com.petraline.trainmanagementservice.repository.TrainlineRepository;

@Controller
public class TrainController {
    private final TrainRepository trainRepository;
    private final TrainlineRepository trainlineRepository;

    public TrainController(TrainRepository trainRepository, TrainlineRepository trainlineRepository) {
        this.trainRepository = trainRepository;
        this.trainlineRepository = trainlineRepository;
    }

    @QueryMapping
    Iterable<Train> trains() {
        return trainRepository.findAll();
    }

    @MutationMapping
    Train addTrain(@Argument TrainInput train) { 
        Trainline trainline = trainlineRepository.findById(train.trainlineId).orElseThrow(() -> new IllegalArgumentException());   
        Train newTrain = new Train(train.name, trainline);
        return trainRepository.save(newTrain);
    }

    record TrainInput(String name, Long trainlineId) {}
}
