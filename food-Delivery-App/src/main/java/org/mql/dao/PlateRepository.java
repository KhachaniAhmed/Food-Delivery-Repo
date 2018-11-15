package org.mql.dao;

import java.util.List;

import org.mql.entities.Plate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlateRepository extends JpaRepository<Plate, Long> {
	@Query("select m from Plate m where m.menu.id=:x")
	public List<Plate> rerchercheParNom(@Param("x")Long id);
	public Plate findPlateByNom(String nom);
}
