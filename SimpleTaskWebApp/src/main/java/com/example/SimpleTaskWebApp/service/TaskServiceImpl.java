package com.example.SimpleTaskWebApp.service;

import com.example.SimpleTaskWebApp.dao.TaskRepository;
import com.example.SimpleTaskWebApp.model.Simpletask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository repository;
    @Override
    public List<Simpletask> findAll() {
        return repository.findAll();
    }

    @Override
    public Simpletask findById(int id) {
        Optional<Simpletask> result=repository.findById(id);
        Simpletask simpletask=null;
        if (result.isPresent()) {
            simpletask = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find  id - " + id);
        }
        return simpletask;
    }

    @Override
    public Simpletask save(Simpletask task) {
        repository.save(task);
        return task;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
