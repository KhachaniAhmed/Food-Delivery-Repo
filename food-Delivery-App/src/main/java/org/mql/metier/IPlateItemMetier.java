package org.mql.metier;

import java.util.List;

import org.mql.entities.Plate;

public interface IPlateItemMetier {
	public void saveplateItem(Plate plate);
	public Plate getPlateByIdItem(Long id);
    public void  deletePlateItem(Long id); 
    public void updatePlateItem(Long id);
    public List<Plate> getAllPlatesItem();
}
