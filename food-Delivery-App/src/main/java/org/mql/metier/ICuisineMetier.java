package org.mql.metier;

import java.util.List;

import org.mql.entities.Cuisine;

public interface ICuisineMetier {
	public List<Cuisine> getAllCuisine();
	public void addCuisine(Cuisine cuisine);

}
