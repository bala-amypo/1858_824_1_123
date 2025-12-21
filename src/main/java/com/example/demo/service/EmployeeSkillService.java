package com.example.demo.service;

import com.example.demo.model.EmployeeSkill;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface EmployeeSkillService {
    public EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill);
    public EmployeeSkill updateEmployeeSkill(Long id, EmployeeSkill employeeSkill);
    public EmployeeSkill getEmployeeSkillById(Long id);
    public List<EmployeeSkill> getAllEmployeeSkills();

    public ResponseEntity<String> deactivateEmployeeSkill(Long id);
}
