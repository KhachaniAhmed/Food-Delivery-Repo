package org.mql.metier;

import java.util.List;

import org.mql.dao.MenuRepository;
import org.mql.entities.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MenuImpl implements IMenuMetier {
	@Autowired
	private MenuRepository menuRepository;

	@Override
	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		return menuRepository.findAll();
	}

	@Override
	public Menu menuByNom(String nom) {
		// TODO Auto-generated method stub
		return menuRepository.findByNom(nom);
	}

	@Override
	public Menu getMenuById(Long id) {
		// TODO Auto-generated method stub
		return menuRepository.getOne(id);
	}

	

	@Override
	public void saveMenu(Menu menu) {

		menuRepository.save(menu);
	}

	@Override
	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMenu(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Menu> getMenuByRestau(Long id) {
		// TODO Auto-generated method stub
		return menuRepository.rerchercheParId(id);
	}

	@Override
	public Menu getMenuByRestaurant(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
