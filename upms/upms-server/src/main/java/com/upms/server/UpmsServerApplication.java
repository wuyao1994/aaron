package com.upms.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.upms.server")
@EnableTransactionManagement
public class UpmsServerApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {

		SpringApplication.run(UpmsServerApplication.class, args);

	}



	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(UpmsServerApplication.class);
	}
}
