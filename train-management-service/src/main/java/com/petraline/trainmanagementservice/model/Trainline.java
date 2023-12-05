package com.petraline.trainmanagementservice.model;


// import org.hibernate.mapping.List;
import java.util.List;

import jakarta.persistence.*;

@Entity(name = "Trainline")
@Table(name = "trainline")
public class Trainline {

    @Id
    @SequenceGenerator(name = "trainline_sequence", sequenceName = "trainline_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainline_sequence")
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(250)")
    private String name;

    @OneToMany(mappedBy = "trainline", cascade = CascadeType.ALL)
    private List<Train> trains ;

    public Trainline() {
    }

    public Trainline(String name) {
        this.name = name;
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
}
