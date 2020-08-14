package com.inventario.microservice.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class MicroServiceProductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProductoApplication.class, args);
	}
	
	@Bean
	public ObjectMapper json() {
		return new ObjectMapper();
	}

}
