package com.db.grad.javaapi.model;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;

@Entity
public class Dog
{
    @Column(name = "dog_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

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
