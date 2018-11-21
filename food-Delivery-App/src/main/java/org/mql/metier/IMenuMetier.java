package org.mql.metier;

import java.util.List;

import javax.validation.Valid;

import org.mql.entities.Menu;
import org.mql.entities.Restaurant;


public interface IMenuMetier {
	public List<Menu> getMenus();
	public Menu getMenuById(Long id);
	public void saveMenu(@Valid Menu menu);
	public Menu menuByNom(String nom);
	public Menu getMenuByRestaurant(Long id);
	public void updateMenu(Menu menu);
	public void deleteMenu(Long id);
	public List<Menu> getMenuByRestau(Long id);
}
