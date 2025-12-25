package com.example.demo.controller;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee-skills")
public class EmployeeSkillController {

    private final EmployeeSkillService employeeSkillService;

    public EmployeeSkillController(EmployeeSkillService employeeSkillService) {
        this.employeeSkillService = employeeSkillService;
    }

    @PostMapping
    public ResponseEntity<EmployeeSkill> create(@RequestBody EmployeeSkill employeeSkill) {
        return ResponseEntity.ok(employeeSkillService.createEmployeeSkill(employeeSkill));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeSkill> update(
            @PathVariable Long id,
            @RequestBody EmployeeSkill employeeSkill
    ) {
        return ResponseEntity.ok(
                employeeSkillService.updateEmployeeSkill(id, employeeSkill)
        );
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EmployeeSkill>> getByEmployee(
            @PathVariable Long employeeId
    ) {
        return ResponseEntity.ok(
                employeeSkillService.getSkillsForEmployee(employeeId)
        );
    }

    @GetMapping("/skill/{skillId}")
    public ResponseEntity<List<EmployeeSkill>> getBySkill(
            @PathVariable Long skillId
    ) {
        return ResponseEntity.ok(
                employeeSkillService.getEmployeesBySkill(skillId)
        );
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        employeeSkillService.deactivateEmployeeSkill(id);
        return ResponseEntity.ok().build();
    }
}
