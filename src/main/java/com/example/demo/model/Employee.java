package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;
@Entity
public class Employee{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Column(unique=true)
    private String email;
    private String department;
    private String jobTitle;
    private Boolean active;
    @CreationTimestamp
    private Timestamp createdAt;
    @CreationTimestamp
    private Timestamp updatedAt;

    // @PrePersist
    // public void onCreate() {
    //     createAt = new
    //     Timestamp(System.currentTimeMillis());
    // }
    //   @PrePersist
    // public void updateAt() {
    //     updateAt = new
    //     Timestamp(System.currentTimeMillis());
    // }

    public long getId() {
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName=fullName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department=department;
    }
    public String getJobTitle(){
        return jobTitle;
    }
    public void setJobTitle(String jobTitle){
        this.jobTitle=jobTitle;
    }
    public Boolean getActive(){
        return active;
    }
    public void setActive(Boolean active){
        this.active=active;
    }
    public Timestamp getCreateAt(){
        return createdAt;
    }
    public Timestamp getUpdatedAt(){
        return updatedAt;
    }
    public Employee(Long id,String fullName,String email,String department,String jobTitle,Boolean active,Timestamp createAt,Timestamp updatedAt){
        this.id=id;
        this.fullName=fullName;
        this.email=email;
        this.department=department;
        this.jobTitle=jobTitle;
        this.active=active;
        this.createdAt=createdAt;
        this.updatedAt=updatedAt;
    }
    public Employee(){

    }
}