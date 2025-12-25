package com.example.demo.controller;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-skills")
public class EmployeeSkillController {

    private final EmployeeSkillService employeeSkillService;

    public EmployeeSkillController(EmployeeSkillService employeeSkillService) {
        this.employeeSkillService = employeeSkillService;
    }

    @PostMapping
    public EmployeeSkill create(@RequestBody EmployeeSkill es) {
        return employeeSkillService.createEmployeeSkill(es);
    }

    @PutMapping("/{id}")
    public EmployeeSkill update(@PathVariable Long id, @RequestBody EmployeeSkill es) {
        return employeeSkillService.updateEmployeeSkill(id, es);
    }

    @GetMapping("/employee/{employeeId}")
    public List<EmployeeSkill> byEmployee(@PathVariable Long employeeId) {
        return employeeSkillService.getSkillsForEmployee(employeeId);
    }

    @GetMapping("/skill/{skillId}")
    public List<EmployeeSkill> bySkill(@PathVariable Long skillId) {
        return employeeSkillService.getEmployeesBySkill(skillId);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        employeeSkillService.deactivateEmployeeSkill(id);
    }
}
