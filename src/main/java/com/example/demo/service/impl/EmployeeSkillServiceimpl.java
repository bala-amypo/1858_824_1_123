package com.example.demo.service.impl;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.EmployeeSkillRepository;

import java.util.List;
import org.springframework.http.ResponseEntity;

@Service
public class EmployeeSkillServiceimpl implements EmployeeSkillService {

    @Autowired
    EmployeeSkillRepository obj;

    @Override
    public EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill){
        return obj.save(employeeSkill);
    }

    @Override
    public EmployeeSkill updateEmployeeSkill(Long id, EmployeeSkill employeeSkill){

        EmployeeSkill exi = obj.findById(id).orElse(null); 

        if(exi != null){
            exi.setSkillLevel(employeeSkill.getSkillLevel());
            exi.setActive(employeeSkill.getActive());
            exi.setEmployee(employeeSkill.getEmployee());
            exi.setSkill(employeeSkill.getSkill());

            return obj.save(exi);
        }

        return null;                               
    }

    @Override
    public EmployeeSkill getEmployeeSkillById(Long id){
        return obj.findById(id).orElse(null);
    }

    @Override
    public List<EmployeeSkill> getAllEmployeeSkills(){
        return obj.findAll();
    }

    @Override
    public ResponseEntity<String> deactivateEmployeeSkill(Long id){

        EmployeeSkill jk = obj.findById(id).orElse(null);

        jk.setActive(false);
        obj.save(jk);

        return ResponseEntity.ok("Employee Skill Deactivated");
    }
}
