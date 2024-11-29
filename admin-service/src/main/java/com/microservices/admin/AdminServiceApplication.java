package com.microservices.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Point d'entrée du service d'administration
 * Configure et démarre le service Spring Boot avec les endpoints REST
 */
@SpringBootApplication
public class AdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServiceApplication.class, args);
    }
}
