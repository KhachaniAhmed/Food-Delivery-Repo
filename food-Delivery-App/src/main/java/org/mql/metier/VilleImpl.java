package org.mql.metier;

import java.util.List;
<<<<<<< HEAD
=======

import org.mql.dao.VilleRepository;
import org.mql.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VilleImpl implements IVilleMetier {
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
import org.mql.dao.VilleRepository;
import org.mql.entities.Quartier;
import org.mql.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VilleImpl implements IVilleMetier {
@Autowired
private VilleRepository villeRepository;
	@Override
	public List<Ville> getAllVilles() {
		
		return villeRepository.findAll();
	}
	@Override
	public Ville vileByNom(String nom) {
		// TODO Auto-generated method stub
		return villeRepository.findVilleByNom(nom);
	}
	@Override
	public Ville villeById(Long id) {
		// TODO Auto-generated method stub
		return villeRepository.findById(id).get();
	}
	@Override
	public void saveVille(Ville ville) {
		villeRepository.save(ville);
		
	}
	
	

}
=======
	@Autowired
	private VilleRepository villeRepository;

	@Override
	public List<Ville> getAllViles() {
		return villeRepository.findAll();
	}

}
>>>>>>> refs/remotes/origin/master
