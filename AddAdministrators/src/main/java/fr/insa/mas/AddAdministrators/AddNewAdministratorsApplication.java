package fr.insa.mas.AddNewAdministrators;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "fr.insa.mas.AddNewAdministrators")
@EnableJpaRepositories(basePackages = "fr.insa.mas.AddNewAdministrators")
public class AddNewAdministratorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddNewAdministratorsApplication.class, args);
    }
}
