package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


@Entity
public class Skill{
    @Id
    private Long id;
    @Column(unique=true)
    private String 

}
