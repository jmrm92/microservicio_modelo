package com.proyecto.modelo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan (basePackages="com.proyecto.modelo.model")
@SpringBootApplication(scanBasePackages = {"com.proyecto.modelo.controller", "com.proyecto.modelo.service"})
public class ModeloApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModeloApplication.class, args);
	}
}
