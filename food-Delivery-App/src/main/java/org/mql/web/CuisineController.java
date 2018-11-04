package org.mql.web;

import java.util.List;

import org.mql.entities.Cuisine;
import org.mql.metier.ICuisineMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = "/cuisines")
public class CuisineController {

	@Autowired
	private ICuisineMetier iCuisineMetier;

	@RequestMapping(method = RequestMethod.GET)
	public String indexc(Model model) {
		List<Cuisine> cuisines = iCuisineMetier.getAllCuisine();
		model.addAttribute("cuisines", cuisines);
		return "cuisine";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String ajouterCuisine(Model model, Cuisine cuisine) {
		iCuisineMetier.addCuisine(cuisine);
		model.addAttribute("cuisine", cuisine);
		return "redirect:/cuisines";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String findone(Model model, @PathVariable Long id) {
		Cuisine cuisine = iCuisineMetier.findone(id);
		model.addAttribute("cuisine", cuisine);
		return "edit";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String deleteCuisine(Model model, @PathVariable Long id) {
	    iCuisineMetier.supprimerCuisine(id);
		return "redirect:/cuisines";
	}
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editerCuisine(Model model, Cuisine cuisine) {
		iCuisineMetier.addCuisine(cuisine);
		model.addAttribute("cuisine", cuisine);
		return "redirect:/cuisines";
	}

}
