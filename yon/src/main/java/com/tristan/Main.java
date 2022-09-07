package com.tristan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// These annotations tell spring boot where to look for the components it should use
@EnableJpaRepositories("com.tristan.*")
@ComponentScan(basePackages={"com.tristan.*"})
@EntityScan("com.tristan.*")

// This annotation marks this class as the entry point for the spring boot server
@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
