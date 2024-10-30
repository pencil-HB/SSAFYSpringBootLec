package com.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.todo"})
public class SpringBootTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTodoApplication.class, args);
	}

}
