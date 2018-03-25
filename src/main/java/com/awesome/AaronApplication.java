package com.awesome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RestController
@SpringBootApplication
public class AaronApplication {

	@RequestMapping("/")
	String index() {
		return "Hello Spring Boot";
	}
	public static void main(String[] args) {
		SpringApplication.run(AaronApplication.class, args);
	}
}
