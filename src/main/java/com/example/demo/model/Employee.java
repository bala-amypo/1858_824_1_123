package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
public class Employee{

    @id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
    public void setId(Long id){
        this.id=id;
    }
    public String getfullName() {
        return fullName;
    }
    public void setfullName(String fullName) {
        this.fullName=fullName;
    }
    public String getemail(String email){
        return email;
    }
    public void setemail(String email){
        this.email=email;
    }
    public String getdepartment(String getdepartment){
        return department;
    }
    public void setdepartment(String department){
        this.department=department;
    }
    public String getjobTitle(String getjobTitle){
        return jobTitle;
    }
    public void setjobTitle(String jobTitle){
        this.jobTitle=jobTitle;
    }
    public Boolean getactive(Boolean getactive){
        return active;
    }
    public void setactive(Boolean active){
        this.department=department;

}