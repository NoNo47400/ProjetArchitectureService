package fr.insa.mas.Volunteers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "fr.insa.mas.Volunteers")
@EnableJpaRepositories(basePackages = "fr.insa.mas.Volunteers")
public class VolunteersApplication {

    public static void main(String[] args) {
        SpringApplication.run(VolunteersApplication.class, args);
    }
}