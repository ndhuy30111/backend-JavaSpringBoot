package com.springboot.apiwebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import com.springboot.apiwebsite.config.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class ApiwebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiwebsiteApplication.class, args);
	}

}
