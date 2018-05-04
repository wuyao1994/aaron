package com.upms.rpc.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.upms.rpc.service")
@EnableTransactionManagement
@MapperScan("com.upms.dao.mapper")
public class UpmsRpcServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(UpmsRpcServiceApplication.class, args);

	}



	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(UpmsRpcServiceApplication.class);
	}
}
