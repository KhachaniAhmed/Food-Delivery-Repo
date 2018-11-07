package org.mql.dao;

import java.util.List;

import org.mql.entities.Quartier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartierRepository extends JpaRepository<Quartier, Long> {

	public List<Quartier> findByVilleId(Long villeId);
}
