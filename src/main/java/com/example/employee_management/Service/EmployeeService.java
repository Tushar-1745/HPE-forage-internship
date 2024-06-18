package com.example.employee_management.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employee_management.Model.Employee;
import com.example.employee_management.Repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(String employee_id) {
        return employeeRepository.findById(employee_id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(String employee_id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(employee_id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employee_id));
        
        employee.setFirst_name(employeeDetails.getFirst_name());
        employee.setLast_name(employeeDetails.getLast_name());
        employee.setEmail(employeeDetails.getEmail());
        employee.setTitle(employeeDetails.getTitle());
        
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(String employee_id) {
        Employee employee = employeeRepository.findById(employee_id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employee_id));
        employeeRepository.delete(employee);
    }
}
