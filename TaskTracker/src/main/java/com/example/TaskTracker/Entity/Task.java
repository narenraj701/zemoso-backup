package com.example.TaskTracker.Entity;

import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="task_id")
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "task")
    private String task;
    @Column(name = "priority")
    private String priority;

    public Task() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Task(String userName, String task, String priority) {
        this.userName = userName;
        this.task = task;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
