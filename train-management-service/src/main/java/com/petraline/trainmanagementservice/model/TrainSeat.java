// TrainSeat.java
package com.petraline.trainmanagementservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trainSeats")
public class TrainSeat {

    @Id
    @SequenceGenerator(
        name="train_seats_sequence",
        sequenceName = "train_seats_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "train_seats_sequence"
    )
    @Column(
        name = "id",
        updatable = false
    )
    private long id;

    @Column(name = "rowNumber", nullable = false)
    private int rowNumber;

    @Column(name = "col", length = 1)
    private char col;

    @ManyToOne
    @JoinColumn(name = "trainClassId")
    private TrainClass trainClass;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public char getCol() {
        return col;
    }

    public void setCol(char col) {
        this.col = col;
    }

    public TrainClass getTrainClass() {
        return trainClass;
    }

    public void setTrainClass(TrainClass trainClass) {
        this.trainClass = trainClass;
    }

    public TrainSeat(){}

    public TrainSeat(int rowNumber, char col, TrainClass trainClass) {
        this.rowNumber = rowNumber;
        this.col = col;
        this.trainClass = trainClass;
    }    
}
