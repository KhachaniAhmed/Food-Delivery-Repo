package org.mql.web;

import java.util.ArrayList;
import java.util.List;

import org.mql.entities.Adresse;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/commande")
public class CommandeController {
	private Restaurant restaurant = new Restaurant();
	private Quartier quartier = new Quartier();
	private Ville ville = new Ville();
	private Adresse adresse = new Adresse();
	private Menu menu = new Menu();
	private List<Ville> villes = new ArrayList<>();
	private boolean villeSelected = false;
	private boolean adresseSelected = false;
	private List<Quartier> quartiers = new ArrayList<>();
	private String valueSelected = "";
	private List<Adresse> adresses = new ArrayList<>();
	private List<Restaurant> restaurants = new ArrayList<>();
	private List<Menu> menus = new ArrayList<>();
	private List<Plate> plates = new ArrayList<>();
	private List<PlateItem> plateItems = new ArrayList<>();
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
	@Autowired
	private IPlateItemMetier iPlateItemMetier;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String acessUser(Model model) {
		this.villes = iVilleMetier.getAllViles();
		model.addAttribute("valueSelected", this.valueSelected);
		model.addAttribute("adresseSelected", this.adresseSelected);
		model.addAttribute("villeSelected", this.villeSelected);
		model.addAttribute("quartiers", this.quartiers);
		model.addAttribute("villes", this.villes);
		model.addAttribute("restaurants", this.restaurants);
		this.restaurants = new ArrayList<>();
		this.quartiers = new ArrayList<>();
//		this.menus = new ArrayList<>();
		this.valueSelected = "";
		this.adresseSelected = false;
		this.villeSelected = false;
		return "adminRestaurant";
	}

	@RequestMapping(value = "/quartierByVille", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveUser(Model model, @RequestParam String villeForm) {
		Ville ville = iVilleMetier.vileByNom(villeForm);
		if (villeForm != null)
			this.quartiers = iQuartierMetier.quartierByVille(ville.getId());
		this.ville = iVilleMetier.vileByNom(villeForm);
		this.valueSelected = villeForm;
		if (this.quartiers != null)
			this.villeSelected = true;
		return "redirect:/commande";
	}

	@RequestMapping(value = "/saveAdresse", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveAdresse(Model model, String nomQuartier) {
		if (nomQuartier != null)
			this.quartier = iQuartierMetier.getQuartierById(Long.parseLong(nomQuartier));
		this.adresses = iAdresseMetier.adresseByQuartier(this.quartier.getId());
		this.adresses.forEach(adres -> {
			System.out.println("**************" + adres.getId());
			this.restaurants.addAll(iRestaurantMetier.RestaurantsByAdresse(adres.getId()));
		});

		if (this.restaurants != null)
			this.adresseSelected = true;

		if (this.quartiers != null)
			this.villeSelected = true;
		return "redirect:/commande";
	}

	@RequestMapping(value = "menu", method = { RequestMethod.GET, RequestMethod.POST })
	public String redirectMenu(Model model) {
		model.addAttribute("menu", this.menu);
		model.addAttribute("plates", this.plates);
		return "voirMenu";
	}

	@RequestMapping(value = "Menu/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String getMenu(Model model, @PathVariable String id) {
		Long idRestaurant = Long.parseLong(id);
		Restaurant restMenu = iRestaurantMetier.getRestaurantById(idRestaurant);
		System.out.println(this.restaurant.toString());
		this.menu = restMenu.getMenu();
		this.plates = this.menu.getPlates();
		return "redirect:/commande/menu";
	}

	@RequestMapping(value = "/menu/plateItem", method = { RequestMethod.GET, RequestMethod.POST })
	public String redirectPlateItem(Model model) {
		model.addAttribute("plateItems", this.plateItems);
		return "voirPlateItem";
	}

	@RequestMapping(value = "PlateItem/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String getPlateitem(Model model, @PathVariable String id) {
		Long idplate = Long.parseLong(id);
		this.plateItems = iPlateMetier.getPlateById(idplate).getPlateItmes();
		return "redirect:/commande/menu/plateItem";
	}

}
