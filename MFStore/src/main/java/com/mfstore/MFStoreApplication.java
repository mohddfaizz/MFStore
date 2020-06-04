package com.mfstore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mfstore.domain.User;
import com.mfstore.domain.security.Role;
import com.mfstore.domain.security.UserRole;
import com.mfstore.service.UserService;
import com.mfstore.utility.SecurityUtility;


@SpringBootApplication
public class MFStoreApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(MFStoreApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setFirstName("Mohd");
		user1.setLastName("Faiz");
		user1.setUsername("f");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("mohddfaizz7862@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1= new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
	}

}
