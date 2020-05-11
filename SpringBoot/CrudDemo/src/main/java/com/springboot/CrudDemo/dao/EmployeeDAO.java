package com.springboot.CrudDemo.dao;

import com.springboot.CrudDemo.entity.Employee;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
    public void saveEmployee(Employee employee);

    public Employee getCustomer(int theId);

    public void deleteEmployee(int theId);
}
