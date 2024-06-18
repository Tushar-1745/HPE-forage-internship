package com.example.employee_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employee_management.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
