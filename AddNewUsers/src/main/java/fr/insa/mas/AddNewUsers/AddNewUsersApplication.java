package fr.insa.mas.AddNewUsers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "fr.insa.mas.AddNewUsers")
@EnableJpaRepositories(basePackages = "fr.insa.mas.AddNewUsers")
public class AddNewUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddNewUsersApplication.class, args);
    }
}
