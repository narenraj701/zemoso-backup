package com.springboot.CrudDemo.service;

import com.springboot.CrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getEmployees();

    public void saveEmployee(Employee theEmployee);

    public Employee getCustomer(int theId);

    public void deleteEmployee(int theId);

}
