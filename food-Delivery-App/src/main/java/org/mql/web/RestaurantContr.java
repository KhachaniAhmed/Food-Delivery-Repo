package org.mql.web;

import java.util.ArrayList;
import java.util.List;

import org.mql.entities.Adresse;
import org.mql.entities.Menu;
import org.mql.entities.Plate;
import org.mql.entities.Quartier;
import org.mql.entities.Restaurant;
import org.mql.entities.User;
import org.mql.entities.Ville;
import org.mql.metier.IAdresseMetier;
import org.mql.metier.IMenuMetier;
import org.mql.metier.IPlateMetier;
import org.mql.metier.IQuartierMetier;
import org.mql.metier.IRestaurantMetier;
import org.mql.metier.IVilleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RestaurantContr {
	private Restaurant restaurant = new Restaurant();
	private Quartier quartier = new Quartier();
	private Ville ville = new Ville();
	private Adresse adresse = new Adresse();

	@Autowired
	private IMenuMetier iMenuMetier;
	@Autowired
	private IVilleMetier iVilleMetier;
	@Autowired
	private IQuartierMetier iQuartierMetier;
	@Autowired
	private IAdresseMetier iAdresseMetier;
	@Autowired
	private IRestaurantMetier iRestaurantMetier;
	@Autowired
	private IPlateMetier iPlateMetier;
//
	@RequestMapping(value = "/adminRestaurant", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveUser(Model model, User user, Ville ville, Adresse adresse, Quartier quartier,
			Restaurant restaurant) {
//		iQuartierMetier.saveQuartier(quartier);
//        iAdresseMetier.saveAdresse(adresse);
//		iVilleMetier.saveVille(ville);
//		iRestaurantMetier.addRestaurant(restaurant);
//		iUserMetier.saveUser(user);
		List<Ville> villes = iVilleMetier.getAllVilles();
		model.addAttribute("users", user);
		model.addAttribute("villes", villes);
		return "adminRestaurant";
	}

	@RequestMapping(value = "/saveInfoRestaurant", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveInfoRestaurant(Model model, String nomRestaurant) {
		System.out.println("**********************" + nomRestaurant);
		if (nomRestaurant != null)
			this.restaurant.setNom(nomRestaurant);
		List<Ville> villes = iVilleMetier.getAllVilles();
		model.addAttribute("villes", villes);
		return "adminRestaurant";
	}

//	@RequestMapping(value = "/saveAdresse", method = { RequestMethod.GET, RequestMethod.POST })
//	public String saveAdresse(Model model, String nomQuartier) {
//		if (nomQuartier != null)
//			this.quartier = iQuartierMetier.getQuartierById(Long.parseLong(nomQuartier));
//		this.quartier.setVille(this.ville);
//		this.adresse.setQuartier(this.quartier);
//
//		iAdresseMetier.saveAdresse(new Adresse(null, null, this.quartier));
//		Adresse adresseRest = iAdresseMetier.adresseByQuartier(this.quartier.getId());
//		System.out.println("*********************" + adresseRest.getId());
//		iRestaurantMetier.addRestaurant(new Restaurant(null, this.restaurant.getNom(), null, null, adresseRest, null));
//		List<Ville> villes = iVilleMetier.getAllVilles();
//		model.addAttribute("villes", villes);
//		return "adminRestaurant";
//	}

	@RequestMapping(value = "/menuPlate", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveUser(Model model, Menu menu) {
//		iQuartierMetier.saveQuartier(quartier);
//        iAdresseMetier.saveAdresse(adresse);
//		iVilleMetier.saveVille(ville);
//		iRestaurantMetier.addRestaurant(restaurant);
//		iUserMetier.saveUser(user);
		List<Restaurant> restaurants = iRestaurantMetier.Restaurants();
		List<Menu> menus = iMenuMetier.getMenus();
		List<Plate> plates = iPlateMetier.getAllPlates();
		List<Ville> villes = iVilleMetier.getAllVilles();
		model.addAttribute("villes", villes);
		model.addAttribute("plates", plates);
		model.addAttribute("restaurants", restaurants);
		model.addAttribute("menus", menus);
		return "restaurantDonnees";
	}

	@RequestMapping(value = "/saveVilleAndQuartier", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveUser(Model model, @RequestParam String nomVille, @RequestParam String nomQuartier) {
		Ville ville = iVilleMetier.vileByNom(nomVille);
		System.out.println(ville.toString());
		iQuartierMetier.saveQuartier(new Quartier(null, nomQuartier, ville));
		List<Ville> villes = iVilleMetier.getAllVilles();
		model.addAttribute("villes", villes);
		return "adminRestaurant";
	}

	@RequestMapping(value = "/quartierByVille", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveUser(Model model, @RequestParam String villeForm) {
		boolean villeSelected = false;
		List<Quartier> quartiers = new ArrayList<>();
		Ville ville = iVilleMetier.vileByNom(villeForm);
		if (villeForm != null)
			quartiers = iQuartierMetier.quartierByVille(ville.getId());
		this.ville = iVilleMetier.vileByNom(villeForm);
		if (quartiers != null)
			villeSelected = true;
		List<Ville> villes = iVilleMetier.getAllVilles();
		model.addAttribute("valueSelected", villeForm);
		model.addAttribute("villeSelected", villeSelected);
		model.addAttribute("quartiers", quartiers);
		model.addAttribute("villes", villes);
		return "adminRestaurant";
	}

	@RequestMapping(value = "/menu", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveMennu(Model model, @RequestParam String villeForm) {
		boolean villeSelected = false;
		List<Quartier> quartiers = new ArrayList<>();
		Ville ville = iVilleMetier.vileByNom(villeForm);
		if (villeForm != null)
			quartiers = iQuartierMetier.quartierByVille(ville.getId());
		this.ville = iVilleMetier.vileByNom(villeForm);
		if (quartiers != null)
			villeSelected = true;
		List<Ville> villes = iVilleMetier.getAllVilles();
		model.addAttribute("valueSelected", villeForm);
		model.addAttribute("villeSelected", villeSelected);
		model.addAttribute("quartiers", quartiers);
		model.addAttribute("villes", villes);
		return "adminRestaurant";
	}

	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	public String voidindex() {
		return "index";
	}
}
