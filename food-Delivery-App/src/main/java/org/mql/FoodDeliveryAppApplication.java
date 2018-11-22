package org.mql;

import java.util.ArrayList;
import java.util.List;

import org.mql.entities.Commande;
import org.mql.entities.Plate;
import org.mql.metier.IAccountMetier;
import org.mql.metier.IMenuMetier;
import org.mql.metier.IPlateMetier;
import org.mql.metier.IRestaurantMetier;
import org.mql.metier.IUserMetier;
import org.mql.metier.IVilleMetier;
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
	@Autowired
	private IRestaurantMetier iRestaurantMetier;
	@Autowired
	private IMenuMetier iMenuMetier;
	@Autowired
	private IUserMetier iUserMetier;
	@Autowired
	private IVilleMetier iVilleMetier;
	@Autowired
	IPlateMetier iPlateMetier;

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
		// System.out.println("^^^^^^"+plates);
//		Stream.of("Khemisset", "Tanger", "Tetouan", "Casablanca", "Merrakech", "Benimelall").forEach(v -> {
//			iVilleMetier.saveVille(new Ville(null, v));
//
//		});
//		Stream.of("Fretoure").forEach(m -> {
//		iMenuMetier.saveMenu(new Menu(null, m));
//
//		});
//		
		
		
//	
//	Stream.of("Tacos","Jondola","PoisonsRestau").forEach(r -> {
//		iRestaurantMetier.addRestaurant(new Restaurant(null, r));
//	});
//Stream.of("sardina","chrana","gamba").forEach(p -> {
//	iPlateMetier.saveplate(new Plate(null, p, null, null, null));
//});

	}

}
