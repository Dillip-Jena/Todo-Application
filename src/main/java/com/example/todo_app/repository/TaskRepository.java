package com.example.todo_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo_app.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
