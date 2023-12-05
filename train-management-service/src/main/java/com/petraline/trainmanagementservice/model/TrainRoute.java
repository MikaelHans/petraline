// TrainRoute.java
package com.petraline.trainmanagementservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trainRoutes")
public class TrainRoute {

    @Id
    @SequenceGenerator(
        name="train_routes_sequence",
        sequenceName = "train_routes_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "train_routes_sequence"
    )
    @Column(
        name = "id",
        updatable = false
    )
    private long id;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @ManyToOne
    @JoinColumn(name = "start_station_id")
    private Station startStation;

    @ManyToOne
    @JoinColumn(name = "end_station_id")
    private Station endStation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Station getStartStation() {
        return startStation;
    }

    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public void setEndStation(Station endStation) {
        this.endStation = endStation;
    }

    public TrainRoute(){}

    public TrainRoute(Train train, Station startStation, Station endStation) {
        this.train = train;
        this.startStation = startStation;
        this.endStation = endStation;
    }

    // getters and setters
    
}
