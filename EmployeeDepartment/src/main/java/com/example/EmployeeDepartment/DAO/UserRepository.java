package com.example.EmployeeDepartment.DAO;

import com.example.EmployeeDepartment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
