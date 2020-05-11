package com.example.EmployeeDepartment.exceptions;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException(String s) {
        super(s);
    }
}
