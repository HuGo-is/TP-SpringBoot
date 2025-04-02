package com.example.demo;

import com.example.demo.services.ArenaRegistrationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	CommandLineRunner registerHero(ArenaRegistrationService arenaRegistrationService) {
		return args -> {
			String serverUrl = "http://51.210.251.137/";
			String studentName = "Hugo Hochart";
			String baseUrl = "http://localhost:8080";

			arenaRegistrationService.registerToArena(serverUrl, studentName, baseUrl);
		};
	}

}
