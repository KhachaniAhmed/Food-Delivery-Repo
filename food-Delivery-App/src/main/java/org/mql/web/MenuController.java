package org.mql.web;

import java.util.List;

import org.mql.entities.Menu;
import org.mql.entities.Plate;
import org.mql.metier.IMenuMetier;
import org.mql.metier.IPlateMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MenuController {
	@Autowired
	private IMenuMetier iMenuMetier;

	@Autowired
    private IPlateMetier iPlateMetier;
	
	@RequestMapping(value = "/allMenus", method = RequestMethod.GET)
	public String allMenu(Model model) {
        List<Menu> menus= iMenuMetier.getMenus();
        int i=233;
        menus.forEach(menu->{
        	iPlateMetier.saveplate(new Plate(null, "",(double)i+100 , menu,null));
        });
		return "adminRestaurant";
	}
}
