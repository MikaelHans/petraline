// TrainClassController.java
package com.petraline.trainmanagementservice.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.petraline.trainmanagementservice.model.Train;
import com.petraline.trainmanagementservice.model.TrainClass;
import com.petraline.trainmanagementservice.repository.TrainClassRepository;
import com.petraline.trainmanagementservice.repository.TrainRepository;

@Controller
public class TrainClassController {

    private final TrainClassRepository trainClassRepository;
    private final TrainRepository trainRepository;

    public TrainClassController(TrainClassRepository trainClassRepository, TrainRepository trainRepository) {
        this.trainClassRepository = trainClassRepository;
        this.trainRepository = trainRepository;
    }

    @QueryMapping
    public Iterable<TrainClass> trainClasses() {
        return trainClassRepository.findAll();
    }

    @MutationMapping
    public TrainClass addTrainClass(@Argument TrainClassInput trainClass) {
        Train train = trainRepository.findById(trainClass.trainId).orElseThrow(() -> new IllegalArgumentException());
        return trainClassRepository.save(new TrainClass(trainClass.carriageNumber, trainClass.name, train));
    }

    record TrainClassInput(long id, int carriageNumber, String name, long trainId){}
}
