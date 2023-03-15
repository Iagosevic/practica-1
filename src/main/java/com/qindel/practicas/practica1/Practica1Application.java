package com.qindel.practicas.practica1;

import com.qindel.practicas.practica1.repositories.JJOORepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@EnableJpaRepositories("com.qindel.practicas.practica1")
//@EnableJpaRepositories(basePackageClasses = JJOORepository.class)
public class Practica1Application {
	public static void main(String[] args) {
		SpringApplication.run(Practica1Application.class, args);
	}

}
