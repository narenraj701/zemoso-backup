package com.example.EmployeeDepartment.services;

import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.entity.Employee;

import java.util.List;

public interface DepService {
    public List<Department> getDepartments();
    public Department addDepartment(Department department);
    public List<Employee> getEmployees(int dep_id);
}
