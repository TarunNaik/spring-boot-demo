package com.springpoc.springbootdemo.service;

import com.springpoc.springbootdemo.exception.EmployeeNotFoundException;
import com.springpoc.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private List<Employee> employees = new ArrayList<>();
    @Override
    public Employee saveEmployee(Employee employee) {
        if(employee.getEmployeeId() == null || employee.getEmployeeId().isBlank()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }
    public Iterable<Employee> getEmployees() {
        return employees;
    }
    @Override
    public Employee getEmployeeById(String empId) {
//       return employees.stream().filter(id-> id.getEmployeeId().equals(empId))
//               .findFirst()
//               .orElseThrow(()->new EmployeeNotFoundException("Employee Not found fro id:{}"+empId));
        return employees.stream().filter(id-> id.getEmployeeId().equals(empId))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Internal Server Error"));
    }

    @Override
    public int deleteEmployeeById(String empId) {
        Employee employee = employees.stream().filter(id-> id.getEmployeeId().equals(empId))
                .findFirst().get();
        return employees.remove(employee)? 1:0;
    }
}
