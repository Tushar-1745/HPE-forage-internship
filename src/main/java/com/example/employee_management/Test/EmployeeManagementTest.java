package com.example.employee_management.Test;
import org.aspectj.lang.annotation.Before;
import com.example.employee_management.Model.Employee;
import com.example.employee_management.Service.EmployeeManager;

import static org.junit.Assert.assertEquals;
import java.util.List;

public class EmployeeManagementTest {

    private EmployeeManager employeeManager;

    @Before(value = "")
    public void setUp() {
        employeeManager = new EmployeeManager();
    }

    @org.junit.Test
    public void testAddEmployee() {
        Employee employee = new Employee();
        employee.setEmployee_id("1");
        employee.setFirst_name("John");
        employee.setLast_name("Doe");
        employee.setEmail("john.doe@example.com");
        employee.setTitle("Developer");

        employeeManager.addEmployee(employee);
        List<Employee> employees = (List<Employee>) employeeManager.getEmployees();

        assertEquals(1, employees.size());
        assertEquals("John", employees.get(0).getFirst_name());
    }

    @org.junit.Test
    public void testGetAllEmployees() {
        Employee employee1 = new Employee();
        employee1.setEmployee_id("1");
        employee1.setFirst_name("John");
        employee1.setLast_name("Doe");
        employee1.setEmail("john.doe@example.com");
        employee1.setTitle("Developer");

        Employee employee2 = new Employee();
        employee2.setEmployee_id("2");
        employee2.setFirst_name("Jane");
        employee2.setLast_name("Smith");
        employee2.setEmail("jane.smith@example.com");
        employee2.setTitle("Product Manager");

        employeeManager.addEmployee(employee1);
        employeeManager.addEmployee(employee2);

        List<Employee> employees = (List<Employee>) employeeManager.getEmployees();

        assertEquals(2, employees.size());
    }
}
