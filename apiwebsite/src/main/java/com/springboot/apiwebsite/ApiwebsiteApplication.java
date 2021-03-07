package com.springboot.apiwebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ApiwebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiwebsiteApplication.class, args);
	}

}
