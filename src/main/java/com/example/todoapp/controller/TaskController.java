package com.example.todoapp.controller;

import com.example.todoapp.model.Response;
import com.example.todoapp.model.Task;
import com.example.todoapp.service.TaskServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TaskController {
    private final TaskServiceImpl taskService;

    //get all tasks
    @GetMapping("/list")
    public ResponseEntity <Response> getTasks() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("tasks", taskService.listTask()))
                        .message("Tasks retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Response> deleteTask (@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", taskService.isDeleted(id)))
                        .message("Task deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity <Response> addTask(@RequestBody @Valid Task task) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("task", taskService.createTask(task)))
                        .message("Task saved")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity <Response> updateTask (@PathVariable("id") long id, @RequestBody Task task) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("task", taskService.updateTask(id, task)))
                        .message("Task updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
