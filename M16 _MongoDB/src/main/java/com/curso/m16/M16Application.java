package com.curso.m16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import com.curso.m16.controller.common.AuditorAwareImpl;

//import com.curso.m16.controller.common.AuditorAwareImpl;

@SpringBootApplication
public class M16Application {

	public static void main(String[] args) {
		SpringApplication.run(M16Application.class, args);
	}
}
