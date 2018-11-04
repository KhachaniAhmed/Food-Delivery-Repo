package org.mql.metier;

import java.util.List;

import org.mql.entities.Restaurant;

public interface IRestaurantMetier {

	public List<Restaurant> getAll();
	
	public void add(Restaurant restaurant);
	
	public void delete(Restaurant restaurant);
}
