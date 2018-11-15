package org.mql.dao;

import org.mql.entities.PlateItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlateItemRepository extends JpaRepository<PlateItem, Long> {
	public PlateItem findByNom(String nom);
}
