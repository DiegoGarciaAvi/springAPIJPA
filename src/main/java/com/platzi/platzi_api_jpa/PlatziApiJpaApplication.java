package com.platzi.platzi_api_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PlatziApiJpaApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(PlatziApiJpaApplication.class, args);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
