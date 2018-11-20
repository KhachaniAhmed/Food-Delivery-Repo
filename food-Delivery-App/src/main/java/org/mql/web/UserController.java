package org.mql.web;

import org.mql.entities.Adresse;
import org.mql.entities.Quartier;
import org.mql.entities.User;
import org.mql.entities.Ville;
import org.mql.metier.IAdresseMetier;
import org.mql.metier.IQuartierMetier;
import org.mql.metier.IUserMetier;
import org.mql.metier.IVilleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@Autowired
	private IUserMetier iUserMetier;
	@Autowired
	private IVilleMetier iVilleMetier;
	@Autowired
	private IQuartierMetier iQuartierMetier;
	@Autowired
	private IAdresseMetier iAdresseMetier;

	@RequestMapping(value = "/userInformation", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveUser(Model model, User user, Ville ville, Adresse adresse, Quartier quartier) {
		iQuartierMetier.saveQuartier(quartier);
		iAdresseMetier.saveAdresse(adresse);
		iVilleMetier.saveVille(ville);
		iUserMetier.saveUser(user);
		model.addAttribute("users", user);
		return "users";
	}

}
