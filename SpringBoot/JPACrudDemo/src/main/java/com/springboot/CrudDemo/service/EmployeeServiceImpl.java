package com.springboot.CrudDemo.service;

import com.springboot.CrudDemo.dao.EmployeeRepository;
import com.springboot.CrudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    public Optional<Employee> getEmployee(int theId) {
        return employeeRepository.findById(theId);
    }

    @Override
    public void deleteEmployee(int theId) {
        employeeRepository.deleteById(theId);
    }
}
