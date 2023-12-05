// TrainStop.java
package com.petraline.trainmanagementservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "trainstops")
public class TrainStop {

    @Id
    @SequenceGenerator(
        name="train_stops_sequence",
        sequenceName = "train_stops_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "train_stops_sequence"
    )
    @Column(
        name = "id",
        updatable = false
    )
    private long id;

    @Column(name = "stop_number", nullable = false)
    private int stopNumber;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    @OneToOne
    @JoinColumn(name = "prev_stop_id", nullable = true)
    private TrainStop prevStop;

    @OneToOne
    @JoinColumn(name = "next_stop_id", nullable = true)
    private TrainStop nextStop;

    @Column(name = "arrival")
    private LocalDateTime arrival;

    @Column(name = "departure")
    private LocalDateTime departure;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStopNumber() {
        return stopNumber;
    }

    public void setStopNumber(int stopNumber) {
        this.stopNumber = stopNumber;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public TrainStop getPrevStop() {
        return prevStop;
    }

    public void setPrevStop(TrainStop prevStop) {
        this.prevStop = prevStop;
    }

    public TrainStop getNextStop() {
        return nextStop;
    }

    public void setNextStop(TrainStop nextStop) {
        this.nextStop = nextStop;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public TrainStop(){}

    public TrainStop(
            int stopNumber, 
            Station station, 
            TrainStop prevStop, 
            TrainStop nextStop,
            LocalDateTime arrival, 
            LocalDateTime departure
        ) {
        this.stopNumber = stopNumber;
        this.station = station;
        this.prevStop = prevStop;
        this.nextStop = nextStop;
        this.arrival = arrival;
        this.departure = departure;
    }

    // getters and setters
}
