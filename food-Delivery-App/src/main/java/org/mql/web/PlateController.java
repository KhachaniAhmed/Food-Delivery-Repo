package org.mql.web;

import java.util.List;

import org.mql.entities.Plate;
import org.mql.metier.IPlateMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/plates")
public class PlateController {
	@Autowired
	private IPlateMetier iPlateMetier;

	@RequestMapping(method = RequestMethod.GET)
	public String getAllPlate(Model model) {
		List<Plate> plates = iPlateMetier.getAllPlates();
		model.addAttribute("plates", plates);
		return "plate";
	}
}
