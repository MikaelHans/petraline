package com.petraline.userservice.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity(name = "User")
@Table(
    name = "\"user\""
)
public class User{

    @Id
    @SequenceGenerator(
        name="user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence"
    )
    @Column(
        name = "id",
        updatable = false
    )
    private long id;

    @Column(
        name = "firstname",
        nullable = false,
        columnDefinition = "VARCHAR(50)"
    )
    private String firstname;

    @Column(
        name = "last_name",
        nullable = false,
        columnDefinition = "VARCHAR(50)"
    )
    private String last_name;

    @Column(
        name = "join_date",
        nullable = false,
        columnDefinition = "timestamp without time zone"
    )
    private Date join_date;

    @Column(
        name = "email",
        nullable = false,
        columnDefinition = "VARCHAR(250)",
        unique = true
    )
    private String email;
    
    public User(){

    }    

    public User(String first_name, String last_name, Date join_date, String email) {
        this.firstname = first_name;
        this.last_name = last_name;
        this.join_date = join_date;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}

