package com.springboot.CrudDemo.service;

import com.springboot.CrudDemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> getEmployees();

    public void saveEmployee(Employee theEmployee);

    public Optional<Employee> getEmployee(int theId);

    public void deleteEmployee(int theId);

}
