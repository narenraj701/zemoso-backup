package com.demo.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class demoRestController {
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello World !!!!!!";
    }
}
