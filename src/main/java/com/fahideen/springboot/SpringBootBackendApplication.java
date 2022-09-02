package com.fahideen.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages  = { "com.*"})
public class SpringBootBackendApplication { 

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendApplication.class, args);
		
	}

}
