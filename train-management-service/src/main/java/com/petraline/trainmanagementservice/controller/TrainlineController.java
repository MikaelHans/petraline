package com.petraline.trainmanagementservice.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.petraline.trainmanagementservice.model.Trainline;
import com.petraline.trainmanagementservice.repository.TrainlineRepository;

@Controller
public class TrainlineController {
    private final TrainlineRepository trainlineRepository;

    public TrainlineController(TrainlineRepository trainlineRepository) {
        this.trainlineRepository = trainlineRepository;
    }

    @QueryMapping
    Iterable<Trainline> trainlines() {
        return trainlineRepository.findAll();
    }

    @MutationMapping
    Trainline addTrainline(@Argument TrainlineInput trainline) {
        Trainline newTrainline = new Trainline(trainline.name);
        return trainlineRepository.save(newTrainline);
    }  

    record TrainlineInput(String name) {}
}
