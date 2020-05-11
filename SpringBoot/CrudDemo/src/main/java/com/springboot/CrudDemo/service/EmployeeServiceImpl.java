package com.springboot.CrudDemo.service;

import com.springboot.CrudDemo.dao.EmployeeDAO;
import com.springboot.CrudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee theEmployee) {
        employeeDAO.saveEmployee(theEmployee);
    }

    @Override
    @Transactional
    public Employee getCustomer(int theId) {
        return employeeDAO.getCustomer(theId);
    }

    @Override
    @Transactional
    public void deleteEmployee(int theId) {
        employeeDAO.deleteEmployee(theId);
    }
}
