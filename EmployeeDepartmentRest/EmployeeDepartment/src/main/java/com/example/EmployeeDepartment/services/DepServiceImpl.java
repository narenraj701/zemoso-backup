package com.example.EmployeeDepartment.services;

import com.example.EmployeeDepartment.DAO.DepRepository;
import com.example.EmployeeDepartment.DAO.EmpRepository;
import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepServiceImpl implements DepService {
    @Autowired
    private DepRepository depRepository;
    @Autowired
    private EmpRepository empRepository;
    @Override
    public List<Department> getDepartments() {
        return  depRepository.findAll();
    }

    @Override
    public Department addDepartment(Department department) {
        Department dep=depRepository.findById(department.getId()).orElse(null);
        if(null==dep)
            dep=new Department();
        dep.setDepName(department.getDepName());
        depRepository.save(dep);
        return dep;
    }

    @Override
    public List<Employee> getEmployees(int dep_id) {
        List<Employee> employeeList=depRepository.findById(dep_id).get().getEmployees();
        return employeeList;
    }
}
