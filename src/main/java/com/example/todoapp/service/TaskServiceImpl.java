package com.example.todoapp.service;

import com.example.todoapp.model.Task;
import com.example.todoapp.repo.TaskRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;

    @Override
    public Task createTask(Task task) {
        log.info("Saving new task: {}", task.getTitle());
        return taskRepo.save(task);
    }

    @Override
    public Collection <Task> listTask() {
        log.info("Retrieving all tasks");
        return taskRepo.findAll();
    }

    @Override
    public Task getTask(Long id) {
        log.info("Retrieving task by id: {}", id);
        return taskRepo.findById(id).get();
    }

    @Override
    public Task updateTask(Long id, Task task) {
        log.info("Updating task: {}", task.getTitle());
        Task updateTask = taskRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id not found: " + id));


        System.out.println(task);

        updateTask.setTitle(task.getTitle());
        updateTask.setDescription(task.getDescription());
        updateTask.setDueDate(task.getDueDate());

        System.out.println(updateTask.getDueDate());

        updateTask.setCreated(task.getCreated());
        updateTask.setCategory(task.getCategory());
        updateTask.setModified(task.getModified());
        updateTask.setIsDeleted(task.getIsDeleted());
        return taskRepo.save(updateTask);
    }

    @Override
    public Boolean isDeleted(Long id) {
        log.info("Deleting task: {}", id);
        taskRepo.deleteById(id);
        return TRUE;
    }
}
