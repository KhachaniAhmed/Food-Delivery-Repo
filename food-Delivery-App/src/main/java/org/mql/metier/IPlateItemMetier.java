package org.mql.metier;

import java.util.List;

import org.mql.entities.Cuisine;
import org.mql.entities.Plate;
import org.mql.entities.PlateItem;

public interface IPlateItemMetier {
	public void saveplateItem(PlateItem plate);
	public Plate getPlateByIdItem(Long id);
	public void deletePlateItem(Long id);
	public void updatePlateItem(Long id);
	public Cuisine cuisineBynom(String nom);
	public PlateItem plateItemById(Long id);
	public List<Plate> getAllPlatesItem();
	public void deletePlateitems();

}
