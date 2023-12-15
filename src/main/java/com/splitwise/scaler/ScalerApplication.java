package com.splitwise.scaler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ScalerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ScalerApplication.class, args);
	}
}
