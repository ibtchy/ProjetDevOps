package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.service.something","com.service.application"})

public class ProjectAchatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectAchatApplication.class, args);
	}

}
