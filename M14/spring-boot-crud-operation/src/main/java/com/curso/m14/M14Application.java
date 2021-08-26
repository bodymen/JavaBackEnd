package com.curso.m14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class M14Application {
	public static void main(String[] args) {
		SpringApplication.run(M14Application.class, args);
	}
}
