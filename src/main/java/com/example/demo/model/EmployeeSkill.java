package com.example.demo.model;
import com.example.demo.model.Employee;
import com.example.demo.model.Skill;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeeSkill{
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name="skill_id")
    private Skill skill;
    private String proficiencyLevel;
    private Long yearsOfExperience;
    private Boolean active;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id=id;
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee){
        this.employee=employee;
    }
    public Skill getSkill() {
        return skill;
    }
    public void setSkill(Skill skill){
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
    public EmployeeSkill(Long id,Employee employee,Skill skill,String proficiencyLevel,Long yearsOfExperience,Boolean active){
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