package org.mql.metier;

import java.util.List;

import org.mql.dao.RestaurantRepository;
import org.mql.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;

public class RestaurantImpl implements IRestaurantMetier {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public List<Restaurant> getAll() {
		return restaurantRepository.findAll();
	}
	
	@Override
	public void add(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
	}

	@Override
	public void delete(Restaurant restaurant) {
		// TODO Auto-generated method stub
		
	}

}
