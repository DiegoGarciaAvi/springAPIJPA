package com.platzi.platzi_api_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlatziApiJpaApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(PlatziApiJpaApplication.class, args);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
