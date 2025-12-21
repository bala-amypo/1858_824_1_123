package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class EmployeeServiceimpl implements EmployeeService {

    @Autowired
    EmployeeRepository obj;

    @Override
    public Employee createEmployee(Employee employee){
        return obj.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee){

        Employee exi = obj.findById(id).orElse(null); 

        if(exi != null){
            exi.setId(employee.getId());              
            exi.setName(employee.getName());
            exi.setEmail(employee.getEmail());
            exi.setDepartment(employee.getDepartment());
            exi.setDesignation(employee.getDesignation());
            exi.setActive(employee.getActive());
            
            return obj.save(exi);                  
        }

        return null;                               
    }

    @Override
    public Employee getEmployeeById(Long id){
        return obj.findById(id).orElse(null);      
    }

    @Override
    public List<Employee> getAllEmployees(){
        return obj.findAll();
    }

    @Override
    public ResponseEntity<String> deactivateEmployee(Long id){

        Employee jk = obj.findById(id).orElse(null);   

        jk.setActive(false);
        obj.save(jk);

        return ResponseEntity.ok("Employee Deactivated");
    }
}
