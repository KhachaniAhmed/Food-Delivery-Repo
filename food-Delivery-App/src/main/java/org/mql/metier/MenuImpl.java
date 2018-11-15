<<<<<<< HEAD
package org.mql.metier;

import java.util.List;

import javax.validation.Valid;

import org.mql.dao.MenuRepository;
import org.mql.entities.Menu;
import org.mql.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

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
	public List<Menu> getMenuByRestaurant(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveMenu(Menu menu) {
		
		menuRepository.save(menu);
	}



}
=======
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
		return null;
	}

	@Override
	public Menu getMenuById(Long id) {
		return menuRepository.findById(id).get();
	}

	@Override
	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub

	}

	@Override
	public Menu saveMenu(Menu menu) {
		return menuRepository.save(menu);
	}

	@Override
	public void deleteMenu(Long id) {
		menuRepository.deleteById(id);
	}

	@Override
	public Menu getMenuByRestaurant(Long idRestaurant) {
		return menuRepository.findByRestaurantId(idRestaurant);
	}

}
>>>>>>> refs/remotes/origin/master
