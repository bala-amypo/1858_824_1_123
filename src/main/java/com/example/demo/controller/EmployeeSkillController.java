package com.example.demo.controller;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeSkill")
public class EmployeeSkillController {

    @Autowired
    EmployeeSkillService employeeSkillService;

    @PostMapping("/create")
    public EmployeeSkill createEmployeeSkill(@RequestBody EmployeeSkill employeeSkill) {
        return employeeSkillService.createEmployeeSkill(employeeSkill);
    }

    @PutMapping("/update/{id}")
    public EmployeeSkill updateEmployeeSkill(@PathVariable Long id,@RequestBody EmployeeSkill employeeSkill) {
        return employeeSkillService.updateEmployeeSkill(id, employeeSkill);
    }

    @GetMapping("/get/{id}")
    public EmployeeSkill getEmployeeSkillById(@PathVariable Long id) {
        return employeeSkillService.getEmployeeSkillById(id);
    }

    @GetMapping("/getAll")
    public List<EmployeeSkill> getAllEmployeeSkills() {
        return employeeSkillService.getAllEmployeeSkills();
    }
    @PutMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivateEmployeeSkill(@PathVariable Long id) {
        return employeeSkillService.deactivateEmployeeSkill(id);
    }
}
