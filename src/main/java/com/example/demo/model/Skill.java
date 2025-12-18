package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


@Entity
public class Skill{
    @Id
    private Long id;
    @Column(unique=true)
    private String name;
    private String category;
    private String description;
    private Boolean active;


    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public String getDescription() {
        return description;
    }
    public void setDescri

}
