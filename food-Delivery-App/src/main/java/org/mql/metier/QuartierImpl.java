package org.mql.metier;

import java.util.List;

import org.mql.dao.QuartierRepository;
import org.mql.entities.Quartier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuartierImpl implements IQuartierMetier {

	@Autowired
	private QuartierRepository quartierRepository;
	@Override
	public List<Quartier> getAllQuartiers(Long villeId) {
		
		return quartierRepository.findByVilleId(villeId);
	}

}
