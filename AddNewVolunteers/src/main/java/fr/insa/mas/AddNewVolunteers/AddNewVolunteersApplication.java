package fr.insa.mas.AddNewVolunteers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "fr.insa.mas.AddNewVolunteers")
@EnableJpaRepositories(basePackages = "fr.insa.mas.AddNewVolunteers")
public class AddNewVolunteersApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddNewVolunteersApplication.class, args);
    }
}