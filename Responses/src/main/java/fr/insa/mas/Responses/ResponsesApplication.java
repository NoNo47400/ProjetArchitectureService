package fr.insa.mas.Responses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "fr.insa.mas.Responses")
@EnableJpaRepositories(basePackages = "fr.insa.mas.Responses")
public class ResponsesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResponsesApplication.class, args);
	}

}
