package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.example.demo","controller","service","entity","error"})
@EnableJpaRepositories("repository")
@EntityScan("entity")
@SpringBootApplication
public class SpringBootTutorialApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTutorialApplication.class, args);
	}
}
