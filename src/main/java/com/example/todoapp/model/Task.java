package com.example.todoapp.model;

import com.example.todoapp.enumeration.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@SQLDelete(sql = "UPDATE task SET is_deleted = true WHERE id =?")
public class Task {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String title;

    private String description;

    private LocalDate dueDate;

    @NotNull(message = "status cannot be empty")
    private String category;

    private Boolean isDeleted = Boolean.FALSE;

    private LocalDate created;

    private LocalDate modified;
}
