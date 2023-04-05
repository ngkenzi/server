package com.example.todoapp;

import com.example.todoapp.model.Task;
import com.example.todoapp.repo.TaskRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static com.example.todoapp.enumeration.Status.TASK_COMPLETED;

@SpringBootApplication
public class TodoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner (TaskRepo taskRepo) {
		return args -> {
			taskRepo.save(new Task(
					null,
					"Do assignment 1",
					"Full stack",
					LocalDate.of(2017, Month.FEBRUARY, 4),
					"TASK_COMPLETED",
					false,
					LocalDate.of(2017, Month.JANUARY,3),
					LocalDate.of(2017, Month.JANUARY,3)));

			taskRepo.save(new Task(
					null, "Do assignment 2",
					"Front end",
					LocalDate.of(2019, Month.SEPTEMBER,1),
					"TASK_COMPLETED",
					false,
					LocalDate.of(2019, Month.DECEMBER,3),
					LocalDate.of(2019, Month.DECEMBER,3)));

			taskRepo.save(new Task(
					null, "Do assignment 3",
					"Back end",
					LocalDate.of(2019, Month.FEBRUARY,3),
					"TASK_COMPLETED",
					false,
					LocalDate.of(2020, Month.JANUARY,3),
					LocalDate.of(2022, Month.JANUARY,3)));
		};
	}

}
