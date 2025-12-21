package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // GET ALL EMPLOYEES
    @GetMapping("/getAll")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // DEACTIVATE EMPLOYEE
    @PutMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivateEmployee(@PathVariable Long id) {
        return employeeService.deactivateEmployee(id);
    }
}
