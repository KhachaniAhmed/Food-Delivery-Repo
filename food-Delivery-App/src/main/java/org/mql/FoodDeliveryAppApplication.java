package org.mql;

import org.mql.entities.Role;
import org.mql.entities.User;
import org.mql.metier.IAccountMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FoodDeliveryAppApplication implements CommandLineRunner {
	@Autowired
	private IAccountMetier accountMetier;

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryAppApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
//		accountMetier.saveUser(new User(null, "ahmed@gmail.com", "123", "admin", null, null, null));
//		accountMetier.saveUser(new User(null, "hicham@gmail.com", "123", "user", null, null, null));
//		accountMetier.saveRole(new Role(null, "ADMIN"));
//		accountMetier.saveRole(new Role(null, "USER"));
//		accountMetier.addRoleToUser("admin", "ADMIN");
//		accountMetier.addRoleToUser("admin", "USER");
//		accountMetier.addRoleToUser("user", "USER");

	}

}
