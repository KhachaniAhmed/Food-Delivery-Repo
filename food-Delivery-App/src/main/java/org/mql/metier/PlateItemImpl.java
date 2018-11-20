package org.mql.metier;

import java.util.List;

import org.mql.dao.CuisineRepository;
import org.mql.dao.PlateItemRepository;
import org.mql.entities.Cuisine;
import org.mql.entities.Plate;
import org.mql.entities.PlateItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlateItemImpl implements IPlateItemMetier {
@Autowired
private PlateItemRepository plateItemRepository;
@Autowired
private CuisineRepository cuisineRepository;


	@Override
	public void saveplateItem(PlateItem plate) {
		
		plateItemRepository.save(plate);
	}

	@Override
	public Plate getPlateByIdItem(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePlateItem(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePlateItem(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Plate> getAllPlatesItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuisine cuisineBynom(String nom) {
		// TODO Auto-generated method stub
		return cuisineRepository.findCuisineByNom(nom);
	}

	@Override
	public PlateItem plateItemByNom(String nom) {
		// TODO Auto-generated method stub
		return plateItemRepository.findByNom(nom);
	}

	


}
