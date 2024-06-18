package com.example.employee_management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_management.Model.Employee;
import com.example.employee_management.Model.Employees;
import com.example.employee_management.Service.EmployeeManager;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;

    @GetMapping
    public Employees getAllEmployees() {
        return employeeManager.getEmployees();
    }
    
    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        employeeManager.addEmployee(employee);
        return new ResponseEntity<>("Employee added successfully", HttpStatus.CREATED);
    }
}