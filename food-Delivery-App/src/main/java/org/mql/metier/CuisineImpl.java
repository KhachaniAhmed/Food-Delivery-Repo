package org.mql.metier;

import java.util.List;

import org.mql.dao.CuisineRepository;
import org.mql.entities.Cuisine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CuisineImpl implements ICuisineMetier {
	@Autowired
	private CuisineRepository cuisineRepository;

	@Override
	public List<Cuisine> getAllCuisine() {
		return cuisineRepository.findAll();
	}

	@Override
	public void addCuisine(Cuisine cuisine) {
		if (cuisine == null)
			throw new RuntimeException("cuisine est vide !!!!");
		cuisineRepository.save(cuisine);
	}

	@Override
	public Cuisine findone(Long id) {
		return cuisineRepository.findById(id).get();
	}

	@Override
	public void supprimerCuisine(Long id) {
		if (id == null)
			throw new RuntimeException("Id est Invalide !!!!");
		cuisineRepository.deleteById(id);
	}

	@Override
	public Cuisine cuisineByNom(String nom) {
		// TODO Auto-generated method stub
		return cuisineRepository.findCuisineByNom(nom);
	}

}
