package com.springboot.CrudDemo.controller;

import com.springboot.CrudDemo.entity.Employee;
import com.springboot.CrudDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }
    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Optional<Employee> employee=employeeService.getEmployee(id);
        if(employee==null)
            return "Employee id not found -"+id;
        employeeService.deleteEmployee(id);
        return "Deleted Customer id "+id;
    }
}
