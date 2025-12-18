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
    public String getCategoryName() {
        return category;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName=categoryName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description=description;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active=active;
    }
    public SkillCategory(Long id,)
}
