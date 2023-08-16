package com.example.gues5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Gues5Application {

	public static void main(String[] args) {
		SpringApplication.run(Gues5Application.class, args);
	}

}
