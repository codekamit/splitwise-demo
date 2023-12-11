package com.splitwise.scaler;

import com.splitwise.scaler.DTOs.RegisterUserRequestDTO;
import com.splitwise.scaler.controllers.GroupController;
import com.splitwise.scaler.controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class ScalerApplication implements CommandLineRunner {

	@Autowired
	private GroupController groupController;

	@Autowired
	private UserController userController;

	public static void main(String[] args) {
		SpringApplication.run(ScalerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String firstName = scanner.nextLine();
		String lastName = scanner.nextLine();
		String email = scanner.nextLine();
		String password = scanner.nextLine();
		RegisterUserRequestDTO registerUserRequestDTO = new RegisterUserRequestDTO(firstName, lastName, email, password);
		userController.registerUser(registerUserRequestDTO);
	}
}
