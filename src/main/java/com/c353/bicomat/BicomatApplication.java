package com.c353.bicomat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.c353")
//@EnableJpaRepositories
public class BicomatApplication {

	public static void main(String[] args) {
		SpringApplication.run(BicomatApplication.class, args);
	}
}
