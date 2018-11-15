package org.mql.metier;

import java.util.List;

import javax.validation.Valid;

import org.mql.entities.Menu;
import org.mql.entities.Ville;
import org.springframework.validation.BindingResult;

public interface IMenuMetier {
	public List<Menu> getMenus();

	public Menu getMenuById(Long id);
<<<<<<< HEAD
	public void saveMenu(@Valid Menu menu);
	public Menu menuByNom(String nom);
	public List<Menu> getMenuByRestaurant(Long id);
=======

	public void updateMenu(Menu menu);

	public Menu saveMenu(Menu menu);

	public void deleteMenu(Long id);
>>>>>>> refs/remotes/origin/master

	public Menu getMenuByRestaurant(Long idRestaurant);

}
