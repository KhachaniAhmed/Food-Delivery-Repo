package org.mql.metier;

import java.util.List;

import org.mql.entities.Quartier;
import org.mql.entities.Ville;

public interface IVilleMetier {
	public List<Ville> getAllVilles();
    public Ville vileByNom(String nom);	
    public Ville villeById(Long id);
    public void saveVille(Ville ville);
}
