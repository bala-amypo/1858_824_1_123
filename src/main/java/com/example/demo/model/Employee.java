package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee{

    @id
    GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    

}