package com.example.EmployeeDepartment.controller;

import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.entity.Employee;
import com.example.EmployeeDepartment.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class restController {
    @Autowired
    private EmpService service;
    @GetMapping("")
    public List<Employee> getAllEmployees(Model model) {
        List<Employee> employees = service.getEmployees();
        model.addAttribute("emps",employees);
        return employees;
    }
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
        return employee;
    }

    @PutMapping("/employee")
    public Employee editEmployee(@RequestBody Employee employee ){
        return service.editEmployee(employee);
    }
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id){
        service.deleteEmployee(id);
        return "Deleted "+id;
    }
    /*@GetMapping("/showEmployeeForm")
    public String showEmployeeForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("obj",employee);
        return "employee-form";
    }*/
}
