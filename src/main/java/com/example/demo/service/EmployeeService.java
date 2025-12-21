package com.example.demo.service;

import com.example.demo.model.Employee;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(Long id, Employee employee);
    public Employee getEmployeeById(Long id);
    public List<Employee> getAllEmployees();
    public ResponseEntity<String> deactivateEmployee(Long id);
}
