package com.example.todoapp.service;

import com.example.todoapp.model.Task;

import java.util.Collection;

public interface TaskService {
    Task createTask(Task task);
    Collection<Task> listTask ();
    Task getTask(Long id);
    Task updateTask (Long id, Task task);

    Boolean isDeleted(Long id);
}
