package org.mql.metier;

import java.util.List;

import org.mql.entities.Restaurant;

public interface IRestaurantMetier {

	public List<Restaurant> getAll();
	
	public Restaurant findOne(Long id);
	
	public void add(Restaurant restaurant);
	
	public void delete(Long id);
}
