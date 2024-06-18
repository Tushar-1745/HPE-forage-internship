package com.example.employee_management.Service;

import org.springframework.stereotype.Service;

import com.example.employee_management.Model.Employee;
import com.example.employee_management.Model.Employees;

@Service
public class EmployeeManager {

    private Employees employees;

    public EmployeeManager() {
        employees = new Employees();
        initializeEmployees();
    }

    private void initializeEmployees() {
        Employee emp1 = new Employee();
        emp1.setEmployee_id("1");
        emp1.setFirst_name("John");
        emp1.setLast_name("Doe");
        emp1.setEmail("john.doe@example.com");
        emp1.setTitle("Software Engineer");

        Employee emp2 = new Employee();
        emp2.setEmployee_id("2");
        emp2.setFirst_name("Jane");
        emp2.setLast_name("Smith");
        emp2.setEmail("jane.smith@example.com");
        emp2.setTitle("Product Manager");

        // Add more employees as needed

        employees.getEmployees().add(emp1);
        employees.getEmployees().add(emp2);
    }

    public Employees getEmployees() {
        return employees;
    }
    
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}
