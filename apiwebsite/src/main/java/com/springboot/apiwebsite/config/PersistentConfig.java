package com.springboot.apiwebsite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.springboot.apiwebsite.service.AuditorAwareImpl;


@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class PersistentConfig {
	@Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }
}
