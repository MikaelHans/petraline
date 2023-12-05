// Station.java
package com.petraline.trainmanagementservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stations")
public class Station {

    @Id
    @SequenceGenerator(
        name="station_sequence",
        sequenceName = "station_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "station_sequence"
    )
    @Column(
        name = "id",
        updatable = false
    )
    private long id;

    @Column(name = "name", length = 250)
    private String name;

    @ManyToOne
    @JoinColumn(name = "city", nullable = false)
    private City city;

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

    public Station(){

    }

    public Station(String name, City city) {
        this.name = name;
        this.city = city;
    }

}
