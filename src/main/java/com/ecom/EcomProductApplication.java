package com.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EcomProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomProductApplication.class, args);
	}

}
