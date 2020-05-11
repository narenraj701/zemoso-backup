package com.example.TaskTracker.controller;

import com.example.TaskTracker.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class controller {
    @Autowired
    TaskService service;
    @GetMapping("/list/{userName}")
    public String getList(@PathVariable String userName){
        service.findByUserName(userName);


    }
}
