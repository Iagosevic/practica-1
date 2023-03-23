package com.qindel.practicas.practica1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.qindel.practicas.practica1.entities"})
@EnableJpaRepositories(basePackages = "com.qindel.practicas.practica1.repositories")
public class Practica1Application {
	public static void main(String[] args) {
		SpringApplication.run(Practica1Application.class, args);
	}

}
