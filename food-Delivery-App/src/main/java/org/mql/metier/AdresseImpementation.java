package org.mql.metier;

import java.util.List;

import org.mql.dao.AdresseRepository;
import org.mql.entities.Adresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class AdresseImpementation implements IAdresseMetier {
	@Autowired
	private AdresseRepository adresseRepository;
	

	@Override
	public void saveAdresse(Adresse adresse) {
		adresseRepository.save(adresse);

	}

	@Override
	public Adresse adresseByNom(String nom) {
		// TODO Auto-generated method stub
		return adresseRepository.findAdresseByInfoAdresse(nom);
	}

	@Override
	public List<Adresse> adresseByQuartier(Long id) {
		return adresseRepository.findByQuartier(id);
	}

}
