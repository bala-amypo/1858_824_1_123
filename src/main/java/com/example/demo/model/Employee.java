package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Employee{

    @id
    GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Column(unique=true)
    private String email;
    private String department;
    private String jobTitle;
    private Boolean active;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public long getId() {
        return id;
    }

}