package org.mql.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mql.dao.MenuRepository;
import org.mql.entities.Adresse;
import org.mql.entities.Commande;
import org.mql.entities.CommandeItem;
import org.mql.entities.Menu;
import org.mql.entities.Plate;
import org.mql.entities.PlateItem;
import org.mql.entities.Quartier;
import org.mql.entities.Restaurant;
import org.mql.entities.User;
import org.mql.entities.Ville;
import org.mql.metier.IAccountMetier;
import org.mql.metier.IAdresseMetier;
import org.mql.metier.ICommandeItemMetier;
import org.mql.metier.ICommandeMetier;
import org.mql.metier.IMenuMetier;
import org.mql.metier.IPlateItemMetier;
import org.mql.metier.IPlateMetier;
import org.mql.metier.IQuartierMetier;
import org.mql.metier.IRestaurantMetier;
import org.mql.metier.IVilleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/commande")
public class CommandeController {
	private List<CommandeItem> commandeItems = new ArrayList<>();
	private Commande commandeValider = new Commande();
	private User user = new User();
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
	private List<PlateItem> plateItemCommander = new ArrayList<>();
	private boolean PlateitemSelected = false;
	boolean plateItemExist = false;
	PlateItem plateitemChoisi = new PlateItem();
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	IAccountMetier iAccountMetier;
	@Autowired
	private MenuRepository menuRepository;
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
	@Autowired
	private ICommandeMetier iCommandeMetier;
	@Autowired
	private ICommandeItemMetier iCommandeItemMetier;	
	private static double prixTotale = 0d;

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
		return "commande/adminRestaurant";
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
		return "commande/voirMenu";
	}

	@RequestMapping(value = "Menu/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String getMenu(Model model, @PathVariable String id, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "4") int s,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {

		Page<Menu> page = menuRepository.cherche("%" + mc + "%", new PageRequest(p, s));
		int[] pages = new int[page.getTotalPages()];
		model.addAttribute("size", s);
		model.addAttribute("pagedef", p);
		model.addAttribute("pages", pages);
		model.addAttribute("listprd", page);
		model.addAttribute("motCle", mc);

		Long idRestaurant = Long.parseLong(id);
		Restaurant restMenu = iRestaurantMetier.getRestaurantById(idRestaurant);
		System.out.println(this.restaurant.toString());
		this.menu = restMenu.getMenu();
		this.plates = this.menu.getPlates();
		return "redirect:/commande/menu";
	}

	@RequestMapping(value = "/menu/plateItem", method = { RequestMethod.GET, RequestMethod.POST })
	public String redirectPlateItem(Model model) {

		model.addAttribute("plateItemCommander", this.plateItemCommander);
		model.addAttribute("plateItems", this.plateItems);
		model.addAttribute("PlateitemSelected", this.PlateitemSelected);
		this.plateitemChoisi = new PlateItem();
		this.plateItemExist = false;
		return "commande/voirPlateItem";
	}

	@RequestMapping(value = "PlateItem/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String getPlateitem(Model model, @PathVariable String id) {
		Long idplate = Long.parseLong(id);
		Plate plate = iPlateMetier.getPlateById(idplate);
		this.plateItems = plate.getPlateItmes();

		return "redirect:/commande/menu/plateItem";
	}

	@RequestMapping(value = "authorPlate", method = { RequestMethod.GET, RequestMethod.POST })
	public String getPreviousPates() {
		return "redirect:/commande/menu";
	}

	@RequestMapping(value = "/choicePLateItem", method = { RequestMethod.GET, RequestMethod.POST })
	public String choicePLateItem(@RequestParam Long id, @RequestParam(name = "quantite") String quantite) {

		System.out.println("id deplate Item" + id);
		int nmberChoice = 0;
		if (!quantite.equals(",")) {
			String[] number = quantite.split(",");
			nmberChoice = Integer.parseInt(number[1]);
			if (nmberChoice == 0) {
				nmberChoice = 1;
			}
		} else {
			nmberChoice = 1;
		}
		this.plateitemChoisi = iPlateItemMetier.plateItemById(id);
		this.plateitemChoisi.setQuantite(nmberChoice);
		this.plateitemChoisi.setPrix(plateitemChoisi.getPrix() * nmberChoice);

		this.plateItemCommander.forEach(plateitem -> {
			if (plateitem.getId() == this.plateitemChoisi.getId()) {
				this.plateItemExist = true;
				plateitem.setPrix(plateitem.getPrix() + this.plateitemChoisi.getPrix());
				plateitem.setQuantite(plateitem.getQuantite() + this.plateitemChoisi.getQuantite());
			}
		});
		if (this.plateItemExist == false) {
			this.plateItemCommander.add(this.plateitemChoisi);
		}
		if (this.plateItemCommander != null)
			this.PlateitemSelected = true;

		return "redirect:/commande/menu/plateItem";
	}

	@RequestMapping(value = "validCommande", method = { RequestMethod.GET, RequestMethod.POST })
	public String validCommande() {
		return "redirect:/commande/login";
	}

	@RequestMapping(value = "login", method = { RequestMethod.GET, RequestMethod.POST })
	public String getLoginPage() {
		return "authentification/login";
	}
	@RequestMapping(value = "regesterView", method = { RequestMethod.GET, RequestMethod.POST })
	public String getRegisterPage() {
		return "authentification/regester";
	}

	@RequestMapping(value = "userSuccess", method = { RequestMethod.GET, RequestMethod.POST })
	public String getRegesterPage() {
		this.plateItemCommander.forEach(pateIem -> {
			prixTotale += pateIem.getPrix();
		});
		System.out.println(this.user.getPassword());
		this.commandeValider = iCommandeMetier
				.addCommande(new Commande(null, prixTotale, new Date(), this.user, this.menu.getRestaurant(), null));
		this.plateItemCommander.forEach(plateItem -> {
			this.commandeItems.add(this.iCommandeItemMetier.addCommandeItem(new CommandeItem(null, plateItem.getPrix(),
					plateItem.getQuantite(), plateItem, this.commandeValider)));
		});
		iCommandeMetier.addCommandeItem(this.commandeValider, this.commandeItems);
		return "authentification/commandDone";
	}

	@RequestMapping(value = "connexion", method = { RequestMethod.GET, RequestMethod.POST })
	public String getUserFromDb(Model model, @RequestParam String username, @RequestParam String password) {
		this.user = iAccountMetier.findUserByUsername(username);
		System.out.println("************" + password);
		if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
			model.addAttribute("user", user);
			return "redirect:/commande/userSuccess";

		} else {
			System.out.println("user idefined");
			return "authentification/login";
		}
	}


	
	@RequestMapping(value = "regesterUser", method = { RequestMethod.GET, RequestMethod.POST })
	public String regesterUser(Model model, User user) {
		user.setAdresse(null);
		this.user=iAccountMetier.saveUser(user);
		return "redirect:/commande/userSuccess";
	}

}
