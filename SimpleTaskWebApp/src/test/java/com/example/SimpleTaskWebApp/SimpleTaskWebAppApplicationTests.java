package com.example.SimpleTaskWebApp;

import com.example.SimpleTaskWebApp.controller.DemoController;
import com.example.SimpleTaskWebApp.dao.TaskRepository;
import com.example.SimpleTaskWebApp.model.Simpletask;
import com.example.SimpleTaskWebApp.service.TaskService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
class SimpleTaskWebAppApplicationTests {
	@Autowired
	private TaskService service;
	@MockBean
	private TaskRepository repository;
	@Test
	void contextLoads(){
	}
	@Test
	public void getTasksTest() {
		Mockito.when(repository.findAll()).thenReturn
				(Stream.of(new Simpletask("do nothing","low"),
						new Simpletask("complete the course","high"))
						.collect(Collectors.toList()));
		Assert.assertEquals(2,service.findAll().size());
	}
	@Test
	public void getTaskByIdTest(){
		int id=1;
		Simpletask task=new Simpletask(1,"Do Nothing","low");
		Mockito.when(repository.findById(id)).thenReturn(Optional.of(task));
		Assert.assertEquals(1,service.findById(id).getId());
	}
	@Test
	public void saveTaskTest(){
		Simpletask task=new Simpletask(1,"Do Nothing","low");
		Mockito.when(repository.save(task)).thenReturn(task);
		Assert.assertEquals(task,service.save(task));
	}
	@Test
	public void deleteTaskTest(){
		Simpletask task=new Simpletask(1,"Do Nothing","low");
		System.out.println(repository.findAll());
		service.delete(task.getId());
		Mockito.verify(repository,Mockito.times(1))
				.deleteById(task.getId());

	}

}
