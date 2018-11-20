package org.mql.web;

import java.util.List;

import org.mql.entities.Ville;
import org.mql.metier.IMenuMetier;
import org.mql.metier.IQuartierMetier;
import org.mql.metier.IRestaurantMetier;
import org.mql.metier.IVilleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VilleController {

	@Autowired
	private IVilleMetier iVilleMetier;
	@Autowired
	IQuartierMetier iQuartierMetier;
	@Autowired
	IRestaurantMetier iRestaurantMetier;
	@Autowired
	IMenuMetier iMenuMetier;

	@RequestMapping(value = "/vuesearsh", method = RequestMethod.GET)
	public String getAll(Model model, Long id, String nom) {

		List<Ville> listevilles = iVilleMetier.getAllVilles();
		Ville ville = new Ville();
		// Ville v=iVilleMetier.villeById(id);
		ville = iVilleMetier.vileByNom(listevilles.get(0).getNom());
		// ville= iVilleMetier.vileByNom(nom);

		// String nomquartier=quartiers.get(0).getNom();
		String vv = listevilles.get(0).getNom();
		String v = ville.getNom();
		listevilles.forEach(lv -> {

			lv.getNom();
		});

		if (vv.equals(v)) {
			// model.addAttribute("redd",quartiers);
//			model.addAttribute("red",quartiers);
			model.addAttribute("villes", listevilles);
		}

//		model.addAttribute("listequartiers", listequartiers);
		return "searsh";
	}

}
