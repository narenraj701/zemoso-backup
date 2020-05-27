package com.example.EmployeeDepartment.controller;

import com.example.EmployeeDepartment.DAO.CustomRepo;
import com.example.EmployeeDepartment.Exceptions.NoDepartmentExists;
import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.entity.Employee;
import com.example.EmployeeDepartment.services.DepartmentService;
import com.example.EmployeeDepartment.services.EmployeeService;
import com.example.EmployeeDepartment.validator.DepartmentValidator;
import com.example.EmployeeDepartment.validator.UserValidator;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    public static int departmentid;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    private DepartmentValidator departmentValidator;
    @Autowired
    CustomRepo customRepo;
    @GetMapping("/employees")
    public String getEmployeesWithNoDepartments(Model model){
        /*List<Employee> emps=entityManager.createQuery("select e from employees e where e.dep_id is :status",
                Employee.class).setParameter("status", null).getResultList();
        System.out.println(emps);*/
        List<Department> deps=departmentService.getDepartments();
        List<Employee> emps=customRepo.getEmployeeNoDepartment();
        model.addAttribute("noDepEmps",emps);
        model.addAttribute("depnames",deps);
        return "assignEmployees";
    }
    @GetMapping("/addEmp")
    public String addEmp(@PathParam("ID") String ID, @PathParam("EMPID") String EMPID, Model model){
        System.out.println(ID);
        System.out.println(EMPID);
        customRepo.addEmployee(EMPID,ID);
        model.addAttribute("empid",EMPID);
        model.addAttribute("depid",ID);
        return "helper";
    }
    @GetMapping("")
    public String getDepartments(Model model) {
        List<Department> list = departmentService.getDepartments();
        model.addAttribute("deps", list);
        return "departments";
    }

    @PostMapping("")
    public String addDepartment(@Valid @ModelAttribute("depObj") Department dep, BindingResult result) {
        departmentValidator.validate(dep,result);
        if (result.hasErrors())
            return "Department-form";
        departmentService.addDepartment(dep);

        return "redirect:/departments";
    }

    @GetMapping("/{id}/employees")
    public String getEmployees(@PathVariable(name = "id") int id, Model model) {
        departmentid = id;
        List<Employee> employeeList = departmentService.getEmployees(id);
        if(employeeList==null){
            throw new NoDepartmentExists("No Department with ->"+id);
        }
        model.addAttribute("emps", employeeList);
        model.addAttribute("empDep",departmentService.getDepById(departmentid).get().getDepartmentName());
        return "employees-list";
    }

    @GetMapping("/showDepartmentForm")
    public String showDepartmentForm(Model model) {
        Department dep = new Department();
        model.addAttribute("depObj", dep);
        return "Department-form";
    }
}
