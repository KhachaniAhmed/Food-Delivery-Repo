package org.mql.metier;

import java.util.List;
<<<<<<< HEAD
=======

import org.mql.entities.Restaurant;

public interface IRestaurantMetier {
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
import org.mql.entities.Adresse;
import org.mql.entities.Restaurant;

public interface IRestaurantMetier {
	
	public List<Restaurant> Restaurants();
	public void addRestaurant(Restaurant restaurant);
	public Restaurant restaurantByNom(String nom);
	//public Adresse adresseByNom(String nom);

	//public List<Cuisine> getAllCuisine();

	
	
=======
	public List<Restaurant> getAll();
	
	public Restaurant findOne(Long id);
	
	public void add(Restaurant restaurant);
	
	public void delete(Long id);
>>>>>>> refs/remotes/origin/master
}
