package com.springpoc.springbootdemo.service;

import com.springpoc.springbootdemo.exception.EmployeeNotFoundException;
import com.springpoc.springbootdemo.model.Employee;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);

    public Iterable<Employee> getEmployees();

    public Employee getEmployeeById(String empId) throws EmployeeNotFoundException;

    public int deleteEmployeeById(String empId);
}
