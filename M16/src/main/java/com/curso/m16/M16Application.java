package com.curso.m16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class M16Application {
	public static void main(String[] args) {
		SpringApplication.run(M16Application.class, args);
	}
}
