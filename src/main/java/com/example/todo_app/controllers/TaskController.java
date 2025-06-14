package com.example.todo_app.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todo_app.models.Task;
import com.example.todo_app.services.TaskService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/tasks")
public class TaskController {

  private final TaskService taskService;

  public TaskController(TaskService taskService){
    this.taskService = taskService;
  }

  @GetMapping
  public String getTasks(Model model){
    List<Task> tasks = taskService.getAllTasks();
    model.addAttribute("tasks", tasks);
    return "tasks";
  }
  
  @PostMapping("/addTask")
  public String createTask(@RequestParam String title){
    taskService.createTask(title);
    return "redirect:/tasks";
  }

  @GetMapping("/deleteTask/{id}")
  public String deleteTask(@PathVariable Long id){
    taskService.deleteTask(id);
    return "redirect:/tasks";
  }

  @GetMapping("/toggleTask/{id}")
  public String toggleTask(@PathVariable Long id){
    taskService.toggleTask(id);
    return "redirect:/tasks";
  }
}
