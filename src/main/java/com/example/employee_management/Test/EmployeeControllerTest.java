package com.example.employee_management.Test;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.employee_management.Model.Employee;
import com.example.employee_management.Controller.EmployeeController;
import com.example.employee_management.Service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest<mockMvc> {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void testAddEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setEmployee_id("1");
        employee.setFirst_name("John");
        employee.setLast_name("Doe");
        employee.setEmail("john.doe@example.com");
        employee.setTitle("Developer");

        when(employeeService.addEmployee(any(Employee.class))).thenReturn(employee);

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employee_id").value("1"))
                .andExpect(jsonPath("$.first_name").value("John"))
                .andExpect(jsonPath("$.last_name").value("Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$.title").value("Developer"));

        verify(employeeService, times(1)).addEmployee(any(Employee.class));
    }

    @Test
    public void testGetEmployees() throws Exception {
        Employee employee = new Employee();
        employee.setEmployee_id("2");
        employee.setFirst_name("Jane");
        employee.setLast_name("Doe");
        employee.setEmail("jane.doe@example.com");
        employee.setTitle("Manager");

        when(employeeService.getAllEmployees()).thenReturn(Collections.singletonList(employee));

        mockMvc.perform(get("/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].employee_id").value("2"))
                .andExpect(jsonPath("$[0].first_name").value("Jane"))
                .andExpect(jsonPath("$[0].last_name").value("Doe"))
                .andExpect(jsonPath("$[0].email").value("jane.doe@example.com"))
                .andExpect(jsonPath("$[0].title").value("Manager"));

        verify(employeeService, times(1)).getAllEmployees();
    }
}
