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
        this.employee=employee;
    }
    public String getSkill() {
        return skill;
    }
    public void setSkill(String skill){
        this.skill=skill;
    }
    public String getProficiencyLevel() {
        return proficiencyLevel;
    }
    public void setProficiencyLevel(String proficiencyLevel) {
        this.proficiencyLevel=proficiencyLevel;
    }
    public Long getYearsOfExperience() {
        return yearsOfExperience;
    }
    public void setYearsOfExperience(Long yearsOfExperience) {
       this.yearsOfExperience=yearsOfExperience;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
       this.active=active;
    }
    public EmployeeSkill(Long id,String employee,String skill,String proficiencyLevel,Long yearsOfExperience,Boolean active){
        this.id=id;
        this.employee=employee;
        this.skill=skill;
        this.proficiencyLevel=proficiencyLevel;
        this.yearsOfExperience=yearsOfExperience;
        this.active=active;
    } 
    public EmployeeSkill()
    {

    }
}