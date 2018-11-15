package org.mql.metier;

import org.mql.entities.Adresse;

public interface IAdresseMetier {

	public void    saveAdresse(Adresse adresse);
	public Adresse adresseByNom(String nom);
	public Adresse adresseByQuartier(Long id);
}
