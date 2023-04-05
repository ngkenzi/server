package com.example.todoapp.enumeration;

public enum Status {
    TASK_COMPLETED("TASK_COMPLETED"),
    TASK_INCOMPLETE("TASK_INCOMPLETE");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
