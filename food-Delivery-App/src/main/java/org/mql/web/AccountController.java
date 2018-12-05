package org.mql.web;

import org.mql.entities.User;
import org.mql.metier.IAccountMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

@Controller
@RequestMapping(value = "/account")
public class AccountController {
	User user= new User();
	@Autowired
	IAccountMetier iAccountMetier;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = "regester", method = { RequestMethod.GET, RequestMethod.POST })
	public String redirect() {
		return "authentification/regester";
	}
//
//	@RequestMapping(value = "connexion", method = { RequestMethod.GET, RequestMethod.POST })
//	public String getUserFromDb(Model model, @RequestParam String username, @RequestParam String password) {
//		this.user = iAccountMetier.findUserByUsername(username);
//		System.out.println("************" + password);
//		if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
//			model.addAttribute("user", user);
//			return "redirect:/commande/userSuccess";
//
//		} else {
//			System.out.println("user idefined");
//			return "authentification/login";
//		}
//	}
//	
//	public User getUser() {
//		return this.getUser();
//	}
//	

}
