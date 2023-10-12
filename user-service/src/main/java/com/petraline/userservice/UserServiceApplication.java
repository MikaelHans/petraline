package com.petraline.userservice;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.petraline.userservice.model.User;
import com.petraline.userservice.repository.UserRepository;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	// @Bean
	// ApplicationRunner runner(UserRepository userRepo) {

	// 	return args -> {
	// 		ArrayList<User> demoUsers = new ArrayList<User>();
	// 		demoUsers.add(new User(
	// 				"Mikael",
	// 				"Hans",
	// 				new Date(0),
	// 				"mikael.hans25@gmail.com"));
	// 		demoUsers.add(new User(
	// 				"Nicholas",
	// 				"Veron",
	// 				new Date(0),
	// 				"nicholas.veron33@gmail.com"));
	// 		demoUsers.add(new User(
	// 				"Amelia",
	// 				"Syatriadi",
	// 				new Date(0),
	// 				"amelia.syatriadi15@gmail.com"));
	// 		demoUsers.add(new User(
	// 				"Cheryl",
	// 				"Halim",
	// 				new Date(0),
	// 				"cheryl.halim13@gmail.com"));
	// 		userRepo.saveAll(demoUsers);
	// 		System.out.println("#########################################");

			
	// 		// for (int i = 0; i < data.size(); i++) {
	// 		// 	System.out.println(data.get(i).getId());
	// 		// 	System.out.println(data.get(i).getFirstname());
	// 		// 	System.out.println(data.get(i).getLastname());
	// 		// 	System.out.println(data.get(i).getEmail());
	// 		// }

	// 	};
	// }
}
