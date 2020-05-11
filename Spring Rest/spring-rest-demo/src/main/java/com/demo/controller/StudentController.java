package com.demo.controller;

import com.demo.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private List<Student> theStudents;
    @PostConstruct
    public void fillStudents(){
        theStudents=new ArrayList<>();
        theStudents.add(new Student("Naren","Raju"));
        theStudents.add(new Student("Nishanth","Badam"));
    }
    @RequestMapping("getStudent/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if ( (studentId >= theStudents.size()) || (studentId < 0) ) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }
    @RequestMapping("getStudents")
    public List<Student> getStudents(){
            return theStudents;
    }


}
