// TrainClass.java
package com.petraline.trainmanagementservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trainClasses")
public class TrainClass {

    @Id
    @SequenceGenerator(
        name="train_classes_sequence",
        sequenceName = "train_classes_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "train_classes_sequence"
    )
    @Column(
        name = "id",
        updatable = false
    )
    private long id;

    @Column(name = "carriage_number", nullable = false)
    private int carriageNumber;

    @Column(name = "name", length = 250)
    private String name;

    @ManyToOne
    @JoinColumn(name = "trainId")
    private Train train;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCarriageNumber() {
        return carriageNumber;
    }

    public void setCarriageNumber(int carriageNumber) {
        this.carriageNumber = carriageNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public TrainClass(){}
    
    public TrainClass(int carriageNumber, String name, Train train) {
        this.carriageNumber = carriageNumber;
        this.name = name;
        this.train = train;
    }

    // getters and setters
    
}
