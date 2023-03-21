package com.qindel.practicas.practica1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EntityScan("com.qindel.practicas.practica1.*")
public class Practica1Application {

	public static void main(String[] args) {
		SpringApplication.run(Practica1Application.class, args);
	}

}
