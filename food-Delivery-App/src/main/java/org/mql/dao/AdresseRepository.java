package org.mql.dao;

import org.mql.entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {
	public Adresse findAdresseByInfoAdresse(String nom);
	@Query("select a from Adresse a where a.quartier.id=:x")
	public Adresse findByQuartier(@Param("x") Long id);

}
