package org.mql.metier;

import java.util.List;

import org.mql.entities.Quartier;

public interface IQuartierMetier {

	public List<Quartier> getAllQuartiers(Long villeId);
}
