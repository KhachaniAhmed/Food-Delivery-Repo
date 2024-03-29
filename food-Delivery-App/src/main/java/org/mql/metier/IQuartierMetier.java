package org.mql.metier;

import java.util.List;

import org.mql.entities.Quartier;

public interface IQuartierMetier {
	public List<Quartier> listequartie();

	public List<Quartier> quartierByVille(Long idVille);

	public Quartier quartierByNom(String nom);

	public void saveQuartier(Quartier quartier);

	public Quartier getQuartierById(Long id);

	public List<Quartier> getAllQuartiers(Long villeId);
}
