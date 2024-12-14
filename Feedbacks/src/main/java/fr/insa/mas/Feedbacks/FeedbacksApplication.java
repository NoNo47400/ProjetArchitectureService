package fr.insa.mas.Feedbacks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "fr.insa.mas.Feedbacks")
@EnableJpaRepositories(basePackages = "fr.insa.mas.Feedbacks")
public class FeedbacksApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedbacksApplication.class, args);
	}

}
