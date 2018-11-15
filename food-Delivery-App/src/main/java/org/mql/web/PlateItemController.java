package org.mql.web;

import java.util.List;

import org.mql.entities.Cuisine;
import org.mql.entities.Menu;
import org.mql.entities.Plate;
import org.mql.entities.PlateItem;
import org.mql.entities.Ville;
import org.mql.metier.ICuisineMetier;
import org.mql.metier.IMenuMetier;
import org.mql.metier.IPlateItemMetier;
import org.mql.metier.IPlateMetier;
import org.mql.metier.IRestaurantMetier;
import org.mql.metier.IVilleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlateItemController {
	@Autowired
	private ICuisineMetier iCuisineMetier; 
	@Autowired
	private IPlateMetier iPlateMetier;
	@Autowired
	private IPlateItemMetier iPlateItemMetier;
	@Autowired
	private IVilleMetier iVilleMetier; 
	@Autowired
	private IMenuMetier iMenuMetier; 

	@RequestMapping(value = "/savePlateItem", method = { RequestMethod.GET, RequestMethod.POST })
	public String savePlateItemByPlate(Model model, @RequestParam String nomPlate, @RequestParam String nomPlateItem,@RequestParam double prix,@RequestParam String nomCuisine,@RequestParam String nomMenu) {
		System.out.println("***************" + nomPlateItem);
		System.out.println("***************" + nomPlate);
		
		Menu menu=iMenuMetier.menuByNom(nomMenu);

		
        Cuisine  cuisine=new Cuisine(null,nomCuisine);
        iCuisineMetier.addCuisine(cuisine);
		Cuisine cuisine1=iCuisineMetier.cuisineByNom(nomCuisine);
        Plate plate=new Plate(null, nomPlate, prix, menu, null);  
		Plate plate1 = iPlateMetier.plateBynom(nomPlate);
		
		iPlateItemMetier.saveplateItem(new PlateItem(null, prix, nomPlateItem, cuisine, plate1));
		PlateItem plateItem=iPlateItemMetier.plateItemByNom(nomPlateItem);
		

		
		List<Plate> plates = iPlateMetier.getAllPlates();
		model.addAttribute("plates", plates);
	     //System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmm"+plate);
		return "plateMenu";
	}
}
