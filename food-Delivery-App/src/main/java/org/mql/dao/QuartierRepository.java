package org.mql.dao;

import java.util.List;

import org.mql.entities.Quartier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuartierRepository extends JpaRepository<Quartier, Long> {
	@Query("select q from Quartier q where q.ville.id=:x")
	public List<Quartier> rerchercheParId(@Param("x")Long id);
	public Quartier findQurtierByNom(String nom);

	public List<Quartier> findByVilleId(Long villeId);
}
