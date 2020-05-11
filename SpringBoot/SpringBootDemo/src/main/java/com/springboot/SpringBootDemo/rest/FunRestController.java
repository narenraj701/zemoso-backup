package com.springboot.SpringBootDemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String sayHello(){
        return "Hello World  "+ LocalDate.now();
    }

}
