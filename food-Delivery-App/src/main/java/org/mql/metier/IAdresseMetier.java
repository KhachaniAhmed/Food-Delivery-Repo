package org.mql.metier;

import java.util.List;

import org.mql.entities.Adresse;

public interface IAdresseMetier {

	public void    saveAdresse(Adresse adresse);
	public Adresse adresseByNom(String nom);
	public List<Adresse> adresseByQuartier(Long id);
}
