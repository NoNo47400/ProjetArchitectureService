package fr.insa.mas.AddResponses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "fr.insa.mas.AddResponses")
@EnableJpaRepositories(basePackages = "fr.insa.mas.AddResponses")
public class AddResponsesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddResponsesApplication.class, args);
	}

}
