package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import com.example.demo.model.Skill;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.EmployeeSkillService;

import java.util.Arrays;
import java.util.List;

public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository employeeSkillRepository;
    private final EmployeeRepository employeeRepository;
    private final SkillRepository skillRepository;

    public EmployeeSkillServiceImpl(
            EmployeeSkillRepository employeeSkillRepository,
            EmployeeRepository employeeRepository,
            SkillRepository skillRepository
    ) {
        this.employeeSkillRepository = employeeSkillRepository;
        this.employeeRepository = employeeRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill) {

        if (employeeSkill.getYearsOfExperience() < 0) {
            throw new IllegalArgumentException("Experience years");
        }

        List<String> allowed = Arrays.asList("Beginner", "Intermediate", "Advanced", "Expert");
        if (!allowed.contains(employeeSkill.getProficiencyLevel())) {
            throw new IllegalArgumentException("Invalid proficiency");
        }

        Employee employee = employeeRepository.findById(
                employeeSkill.getEmployee().getId()
        ).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        Skill skill = skillRepository.findById(
                employeeSkill.getSkill().getId()
        ).orElseThrow(() -> new ResourceNotFoundException("Skill not found"));

        if (!employee.getActive()) {
            throw new IllegalArgumentException("inactive employee");
        }

        if (!skill.getActive()) {
            throw new IllegalArgumentException("inactive skill");
        }

        return employeeSkillRepository.save(employeeSkill);
    }

    @Override
    public EmployeeSkill updateEmployeeSkill(Long id, EmployeeSkill employeeSkill) {
        EmployeeSkill existing = employeeSkillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EmployeeSkill not found"));

        existing.setProficiencyLevel(employeeSkill.getProficiencyLevel());
        existing.setYearsOfExperience(employeeSkill.getYearsOfExperience());

        return employeeSkillRepository.save(existing);
    }

    @Override
    public List<EmployeeSkill> getSkillsForEmployee(Long employeeId) {
        return employeeSkillRepository.findByEmployeeIdAndActiveTrue(employeeId);
    }

    @Override
    public List<EmployeeSkill> getEmployeesBySkill(Long skillId) {
        return employeeSkillRepository.findBySkillIdAndActiveTrue(skillId);
    }

    @Override
    public void deactivateEmployeeSkill(Long id) {
        EmployeeSkill existing = employeeSkillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EmployeeSkill not found"));
        existing.setActive(false);
        employeeSkillRepository.save(existing);
    }
}
