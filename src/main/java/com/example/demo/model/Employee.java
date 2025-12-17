package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import 

@Entity
public class Employee{

    @id
    GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Column(unique=true)
    private String email;
    private

}