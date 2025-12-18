package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeeSkill{
    @Id
    private Long id;
    private String employee;
    private String skill;
    private String proficiencyLevel;
    private Long yearsOfExperience;
    private Boolean active;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id=id;
    }
    public String getEmployee() {
        return employee;
    }
    public void setEmployee(String employee){
        this
    public String getSkill() {
        ret
    public void setSkill(String skill){
        this.skill=skill;
    }
    public String get 
}