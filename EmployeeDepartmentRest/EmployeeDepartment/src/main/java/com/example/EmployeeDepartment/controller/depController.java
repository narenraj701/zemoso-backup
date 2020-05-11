package com.example.EmployeeDepartment.controller;

import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.entity.Employee;
import com.example.EmployeeDepartment.services.DepService;
import com.example.EmployeeDepartment.services.DepServiceImpl;
import com.example.EmployeeDepartment.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.LongSummaryStatistics;

@RestController
@RequestMapping("/departments")
public class depController {
    @Autowired
    private DepService depService;
    @GetMapping("")
    public List<Department> getDepartments(Model model){
        List<Department> list=depService.getDepartments();
        model.addAttribute("deps",list);
        return list;
    }
    @PostMapping("")
    public Department addDepartment(@RequestBody Department dep){
        return depService.addDepartment(dep);
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees(@RequestParam(name = "id") int id,Model model){

        List<Employee> employeeList=depService.getEmployees(id);
        model.addAttribute("emps",employeeList);
        return employeeList;
    }
}
