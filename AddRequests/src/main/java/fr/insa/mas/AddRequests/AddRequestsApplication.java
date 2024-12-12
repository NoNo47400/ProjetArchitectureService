package fr.insa.mas.AddRequests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "fr.insa.mas.AddRequests")
@EnableJpaRepositories(basePackages = "fr.insa.mas.AddRequests")
public class AddRequestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddRequestsApplication.class, args);
	}

}
