package com.springpoc.springbootdemo.controller;

import com.springpoc.springbootdemo.exception.EmployeeNotFoundException;
import com.springpoc.springbootdemo.model.Employee;
import com.springpoc.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @GetMapping("/getAll")
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{empId}")
    public Employee getEmployeeById(@PathVariable final String empId) throws EmployeeNotFoundException {
        return employeeService.getEmployeeById(empId);
    }

    @DeleteMapping("/remove/{empId}")
    public int deleteEmployee(@PathVariable final String empId) {
        return employeeService.deleteEmployeeById(empId);
    }
}
