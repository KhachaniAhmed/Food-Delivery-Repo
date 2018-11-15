package org.mql.metier;

import java.util.List;

import org.mql.entities.Plate;

public interface IPlateMetier {

	// public void saveplate(Plate plate);

	public void saveplate(Plate plate);

	public Plate getPlateById(Long id);

	// public void deletePlate(Long id);
	// public void updatePlate(Long id);
	public Plate plateBynom(String nom);

	public void deletePlate(Long id);

	public void updatePlate(Long id);

	public List<Plate> getAllPlates();

	public List<Plate> findByMenuId(Long idMenu);

}
