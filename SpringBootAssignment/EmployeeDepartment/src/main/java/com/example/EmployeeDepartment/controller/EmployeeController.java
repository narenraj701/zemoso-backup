package com.example.EmployeeDepartment.controller;

import com.example.EmployeeDepartment.entity.Employee;
import com.example.EmployeeDepartment.services.DepartmentService;
import com.example.EmployeeDepartment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.EmployeeDepartment.controller.DepartmentController.departmentid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("")
    public String getAllEmployees(Model model) {
        List<Employee> employees = service.getEmployees();
        model.addAttribute("emps", employees);
        return "employees-list";
    }

    @PostMapping()
    public String addEmployee(@Valid @ModelAttribute("obj") Employee employee, BindingResult result) {
        if (result.hasErrors())
            return "employee-form";
        service.addEmployee(employee, departmentid);
        return "redirect:/departments/" + departmentid + "/employees";
    }

    @GetMapping("/{id}")
    public String updateEmployee(@PathVariable(name = "id") int id, Model model) {
        Employee emp = service.getEmployeeById(id);
        model.addAttribute("obj", emp);
        return "employee-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id") int id) {
        service.deleteEmployee(id);
        return "redirect:/departments/" + departmentid + "/employees";
    }

    @GetMapping("/showEmployeeForm")
    public String showEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("obj", employee);
        return "employee-form";
    }
}
