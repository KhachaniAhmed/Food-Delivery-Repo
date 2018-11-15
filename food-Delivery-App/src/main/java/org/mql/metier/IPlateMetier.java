package org.mql.metier;

import java.util.List;

import org.mql.entities.Plate;

public interface IPlateMetier {
<<<<<<< HEAD

	public void  saveplate(Plate plate);
=======
	public void saveplate(Plate plate);

>>>>>>> refs/remotes/origin/master
	public Plate getPlateById(Long id);
<<<<<<< HEAD
	public void  deletePlate(Long id);
	public void  updatePlate(Long id);
	public Plate plateBynom(String nom);
=======

	public void deletePlate(Long id);

	public void updatePlate(Long id);

>>>>>>> refs/remotes/origin/master
	public List<Plate> getAllPlates();

	public List<Plate> findByMenuId(Long idMenu);

}
