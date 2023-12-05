package com.petraline.trainmanagementservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="city")
public class City {
    
    @Id
    @SequenceGenerator(
        name="city_sequence",
        sequenceName = "city_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "city_sequence"
    )
    @Column(
        name = "id",
        updatable = false
    )
    private long id;

    @Column(name = "name", length = 250)
    private String name;

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

    public City(){}

    public City(String name) {
        this.name = name;
    }
}
