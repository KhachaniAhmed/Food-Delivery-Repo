package org.mql.metier;

import java.util.List;

import org.mql.entities.Adresse;
import org.mql.entities.Restaurant;

public interface IRestaurantMetier {
	
	public List<Restaurant> Restaurants();
	public void addRestaurant(Restaurant restaurant);
	public Restaurant restaurantByNom(String nom);
	//public Adresse adresseByNom(String nom);

	//public List<Cuisine> getAllCuisine();

	
	
}
