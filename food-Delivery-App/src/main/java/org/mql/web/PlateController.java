package org.mql.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.mql.entities.Adresse;
import org.mql.entities.Cuisine;
import org.mql.entities.Menu;
import org.mql.entities.Plate;
import org.mql.entities.PlateItem;
import org.mql.entities.Quartier;
import org.mql.entities.Restaurant;
import org.mql.entities.Ville;
import org.mql.metier.IAdresseMetier;
import org.mql.metier.IMenuMetier;
import org.mql.metier.IPlateItemMetier;
import org.mql.metier.IPlateMetier;
import org.mql.metier.IQuartierMetier;
import org.mql.metier.IRestaurantMetier;
import org.mql.metier.IVilleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlateController {
@Autowired
private IMenuMetier iMenuMetier;
@Autowired
private IPlateMetier iPlateMetier; 
@Autowired
private IRestaurantMetier iRestaurantMetier;
@Autowired
private IPlateItemMetier iPlateItemMetier;
@Autowired
private IAdresseMetier iAdresseMetier; 
@Autowired
private IQuartierMetier iQuartierMetier;
@Autowired
private IVilleMetier iVilleMetier; 
	
	@RequestMapping(value = "/saveMenuAndPlate", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveMenu(Model model, @RequestParam String nomMenu, @RequestParam String nomPlate) {
		System.out.println("***************" + nomPlate);
		System.out.println("***************" + nomMenu);
		Menu menu=iMenuMetier.menuByNom(nomMenu);
		//System.out.println(menu.toString());
		iPlateMetier.saveplate(new Plate(null, nomPlate, null, menu, null));
		List< Menu> menus=iMenuMetier.getMenus();
		List<Plate> plates=iPlateMetier.getAllPlates();
		model.addAttribute("plates", plates);
		model.addAttribute("menus", menus);
		return "plateItemsDonnees";
	}
	@RequestMapping(value = "/saveRestaurantAndMenu", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveRestaurant(Model model, @RequestParam String nomRestaurant, @RequestParam String nomMenu,
			@RequestParam String nomAdresse,@RequestParam String nomQuartier,@RequestParam String nomVille) {
		
		//Ville ville=new Ville(null, nomVille);
		//iVilleMetier.saveVille(ville);
		  Ville ville2=iVilleMetier.vileByNom(nomVille);
		
		//Quartier quartier=new Quartier(null, nomQuartier, null);
		iQuartierMetier.saveQuartier(new Quartier(null, nomQuartier, ville2));
		Quartier quartier2=iQuartierMetier.quartierByNom(nomQuartier);
		
		 Adresse  adresse=new Adresse(null, nomAdresse, quartier2);
		 iAdresseMetier.saveAdresse(adresse);
		 Adresse adresse2=iAdresseMetier.adresseByNom(nomAdresse);
		 
		 //Ville ville = iVilleMetier.vileByNom(nomVille);
		Restaurant restaurant=iRestaurantMetier.restaurantByNom(nomRestaurant);
		//iRestaurantMetier.addRestaurant(new Restaurant(id, nom, adminRestau, commandes, adresse2, menu));
		//iAdresseMetier.saveAdresse(new Adresse(id, infoAdresse, quartier2));
		//iAdresseMetier.saveAdresse(new Adresse(null, null, quartier2));
		iRestaurantMetier.addRestaurant(new Restaurant(null, nomRestaurant,null, null, adresse2, null));
		iMenuMetier.saveMenu(new Menu(null, nomMenu, null, restaurant));
		List<Restaurant> restaurants=iRestaurantMetier.Restaurants();
		List<Plate> plates=iPlateMetier.getAllPlates();
		List< Menu> menus=iMenuMetier.getMenus();
		model.addAttribute("menus", menus);
		model.addAttribute("plates", plates);
		List<Ville> villes = iVilleMetier.getAllVilles();
		model.addAttribute("villes", villes);
		model.addAttribute("restaurants", restaurants);
		return "plateDonnees";
	} 
	
	

	 
	}

