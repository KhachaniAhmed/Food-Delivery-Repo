package org.mql.metier;

import java.util.List;

<<<<<<< HEAD
import org.aspectj.weaver.NewParentTypeMunger;
import org.mql.dao.QuartierRepository;
import org.mql.dao.VilleRepository;
import org.mql.entities.Quartier;
import org.mql.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
=======
import org.mql.dao.QuartierRepository;
import org.mql.entities.Quartier;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> refs/remotes/origin/master
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuartierImpl implements IQuartierMetier {
	@Autowired
	private QuartierRepository quartierRepository;
	@Autowired
	private IVilleMetier iVilleMetier;

	@Override
	public List<Quartier> listequartie() {
		return quartierRepository.findAll();
	}

	@Override
	public List<Quartier> quartierByVille(Long idVille) {
		return quartierRepository.rerchercheParId(idVille);
	}

	@Override
	public void saveQuartier(Quartier quartier) {
		quartierRepository.save(quartier);

	}

	@Override
	public Quartier quartierByNom(String nom) {
		// TODO Auto-generated method stub
		return quartierRepository.findQurtierByNom(nom);
	}

	@Override
	public Quartier getQuartierById(Long id) {

		return quartierRepository.getOne(id);
	}

	@Autowired
	private QuartierRepository quartierRepository;
	@Override
	public List<Quartier> getAllQuartiers(Long villeId) {
		
		return quartierRepository.findByVilleId(villeId);
	}

}
