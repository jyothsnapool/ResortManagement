package com.innovator.resort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ResortApplication {
	public static void main(String[] args) {
		SpringApplication.run(ResortApplication.class, args);
	}

}
