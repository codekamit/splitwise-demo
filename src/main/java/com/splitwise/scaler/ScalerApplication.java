package com.splitwise.scaler;

import com.splitwise.scaler.models.Group;
import com.splitwise.scaler.models.User;
import com.splitwise.scaler.repositories.GroupRepository;
import com.splitwise.scaler.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableJpaAuditing
public class ScalerApplication {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private GroupRepository groupRepository;
	public static void main(String[] args) {
		SpringApplication.run(ScalerApplication.class, args);
	}
}
