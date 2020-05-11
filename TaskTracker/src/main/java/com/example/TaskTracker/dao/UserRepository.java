package com.example.TaskTracker.dao;

import com.example.TaskTracker.Entity.Task;
import com.example.TaskTracker.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String userName);
}
