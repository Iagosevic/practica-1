package com.qindel.practicas.practica1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.logging.*;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(JJOORepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new JJOOEntity(1, "España", 1, "Barcelona", 200, "verano"));
            repository.save(new JJOOEntity(2, "Francia", 2, "Paris", 300, "verano"));
            repository.save(new JJOOEntity(3, "Portugal", 33, "Lisboa", 111, "invierno"));
            repository.save(new JJOOEntity(4, "Alemania", 55, "Berlin", 500, "verano"));


            // fetch all customers
            log.info("jjoo found with findAll():");
            log.info("-------------------------------");
            for (JJOOEntity jjoo : repository.findAll()) {
                log.info(jjoo.toString());
            }
            log.info("");

            // fetch an individual jjoo by ID
            JJOOEntity jjoo = repository.findById(1);
            log.info("jjoo found with findById(1L):");
            log.info("--------------------------------");
            log.info(jjoo.toString());
            log.info("");

        };
    }

}
