package org.mql.dao;

import java.util.List;

import org.mql.entities.Plate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlateRepository extends JpaRepository<Plate, Long> {

	public List<Plate> findByMenuId(Long idMenu);

}
