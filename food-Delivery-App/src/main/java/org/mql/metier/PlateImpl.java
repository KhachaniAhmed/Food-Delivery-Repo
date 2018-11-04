package org.mql.metier;

import java.util.List;

import org.mql.dao.PlateRepository;
import org.mql.entities.Plate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlateImpl implements IPlateMetier {
	@Autowired
	private PlateRepository plateRepository;

	@Override
	public void saveplate(Plate plate) {
		plateRepository.save(plate);

	}

	@Override
	public Plate getPlateById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePlate(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePlate(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Plate> getAllPlates() {
		return plateRepository.findAll();
	}

}
