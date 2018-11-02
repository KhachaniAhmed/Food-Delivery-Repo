package org.mql.web;

import java.util.List;
import org.mql.entities.Cuisine;
import org.mql.metier.ICuisineMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

@Controller
public class CuisineController {
	@Autowired
	private ICuisineMetier iCuisineMetier;

	@RequestMapping(name = "/cuisine")
	public String indexc(Model model) {
		List<Cuisine> cuisines = iCuisineMetier.getAllCuisine();
		model.addAttribute("cuisine", cuisines);
		return "cuisine";
	}
	
	@RequestMapping(value = "/ajouter" , method=RequestMethod.POST)
	public String ajouterCuisine(Model model , Cuisine cuisine) {
	     iCuisineMetier.addCuisine(cuisine);
		return "redirect:/cuisine";
	}
	
	

}
