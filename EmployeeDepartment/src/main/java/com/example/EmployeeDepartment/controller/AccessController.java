package com.example.EmployeeDepartment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessController {
    @GetMapping("/denied")
    public String deniedPage(){
        return "denied";
    }
    @GetMapping("/profile")
    public String profilePage(){
        return "profile";
    }
}
