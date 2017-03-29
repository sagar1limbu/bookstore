package com.bookstore;
import com.bookstore.domain.Users;
import com.bookstore.domain.security.Role;
import com.bookstore.domain.security.UserRole;
import com.bookstore.service.UserService;
import com.bookstore.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	public void run(String... args) throws Exception{
		Users user1 = new Users();
		user1.setFirstName("john");
		user1.setLastName("dick");
		user1.setUsername("moom");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("lovely11sagar@gmail.com");

		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1,role1));
		userService.createUser(user1,userRoles);
	}

}
