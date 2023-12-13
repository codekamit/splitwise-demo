package com.splitwise.scaler;

import com.splitwise.scaler.DTOs.RegisterUserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class ScalerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ScalerApplication.class, args);
	}
}
