package com.microservices.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Point d'entrée de l'application de service utilisateur
 * Configure et démarre le service Spring Boot avec les services SOAP
 */
@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
