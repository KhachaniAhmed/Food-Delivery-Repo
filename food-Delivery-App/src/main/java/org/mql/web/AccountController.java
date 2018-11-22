package org.mql.web;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String indexc(Model model) {
		return "~/login";
	}

}
