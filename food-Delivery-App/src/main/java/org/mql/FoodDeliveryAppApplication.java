package org.mql;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.mql.dao.QuartierRepository;
import org.mql.dao.VilleRepository;
import org.mql.entities.Commande;
import org.mql.entities.Menu;
import org.mql.entities.Plate;
import org.mql.entities.Quartier;
import org.mql.entities.Restaurant;
import org.mql.entities.User;
import org.mql.entities.Ville;
import org.mql.metier.IMenuMetier;
import org.mql.metier.IPlateMetier;
import org.mql.metier.IQuartierMetier;
import org.mql.metier.IRestaurantMetier;
import org.mql.metier.IUserMetier;
import org.mql.metier.IVilleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;

@SpringBootApplication
public class FoodDeliveryAppApplication implements CommandLineRunner {
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
	
	
	List<Commande> commandes = new ArrayList<>();
	List<Plate> plates=new ArrayList<>();
	// private IVilleMetier iVilleMetier;
//	@Autowired
//	private IQuartierMetier iQuartierMetier;
//	@Autowired
//	private IMenuMetier iMenuMetier;

	public static void main(String[] args) {
		
		SpringApplication.run(FoodDeliveryAppApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
    //System.out.println("^^^^^^"+plates);
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
