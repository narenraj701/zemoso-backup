package com.example.SimpleTaskWebApp.service;

import com.example.SimpleTaskWebApp.model.Simpletask;

import java.util.List;

public interface TaskService {
    public List<Simpletask> findAll();
    public Simpletask findById(int id);
    public Simpletask save(Simpletask task);
    public void delete(int id);
}
