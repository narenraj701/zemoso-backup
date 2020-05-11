package com.example.SimpleTaskWebApp.controller;

import com.example.SimpleTaskWebApp.model.Simpletask;
import com.example.SimpleTaskWebApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DemoController {
    @Autowired
    TaskService service;

    @GetMapping("/list")
    public String getTasks(Model myModel){
        List<Simpletask> taskList=service.findAll();
        myModel.addAttribute("allTasks",taskList);
        return "list-tasks";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Simpletask simpletask = new Simpletask();

        theModel.addAttribute("obj", simpletask);

        return "task-form";
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute("obj") Simpletask simpletask) {

        // save the Task
        service.save(simpletask);

        // use a redirect to prevent duplicate submissions
        return "redirect:list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id,
                                    Model theModel) {

        // get the employee from the service
        Simpletask simpletask = service.findById(id);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("obj", simpletask);

        // send over to our form
        return "task-form";
    }
    @GetMapping("/delete")
    public String deleteTask(@RequestParam("id") int theId){

        service.delete(theId);
        return "redirect:list";
    }

}
