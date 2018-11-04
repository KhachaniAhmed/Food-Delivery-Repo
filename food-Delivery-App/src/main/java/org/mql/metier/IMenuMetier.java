package org.mql.metier;

import java.util.List;

import org.mql.entities.Menu;

public interface IMenuMetier {
	public List<Menu> getMenus();
	public Menu getMenuById(Long id);
	public void updateMenu(Menu menu);
	public void saveMenu(Menu menu);
	public void deleteMenu(Long id);

}
