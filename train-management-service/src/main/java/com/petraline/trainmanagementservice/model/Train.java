package com.petraline.trainmanagementservice.model;

import jakarta.persistence.*;

@Entity(name = "Train")
@Table(name = "train")
public class Train {

    @Id
    @SequenceGenerator(name = "train_sequence", sequenceName = "train_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "train_sequence")
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(250)")
    private String name;

    @ManyToOne
    @JoinColumn(name = "trainline", nullable = false)
    private Trainline trainline;


    public Train(String name, Trainline trainline) {
        this.name = name;
        this.trainline = trainline;
    }

    public Train() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trainline getTrainline() {
        return trainline;
    }

    public void setTrainline(Trainline trainline) {
        this.trainline = trainline;
    }

  

    
}
