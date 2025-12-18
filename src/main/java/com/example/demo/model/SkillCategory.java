package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class SkillCategory{
    @Id
    private Long id;
    @column(unique = true)
    private String categoryName;
    private String description;
    private Booleaan active;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
