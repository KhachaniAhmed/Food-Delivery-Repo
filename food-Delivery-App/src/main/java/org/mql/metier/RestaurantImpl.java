package org.mql.metier;

import java.util.List;

import org.mql.dao.RestaurantRepository;
import org.mql.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RestaurantImpl implements IRestaurantMetier {
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public List<Restaurant> Restaurants() {
		return restaurantRepository.findAll();
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant restaurantByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<Restaurant> getAll() {
		return restaurantRepository.findAll();
	}
	
	@Override
	public void add(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
	}

	@Override
	public void delete(Long id) {
		if (id == null)
			throw new RuntimeException("Id est Invalide !!!!");
		restaurantRepository.deleteById(id);
		
	}

	@Override
	public Restaurant findOne(Long id) {
		return restaurantRepository.findById(id).get();
	}

}
