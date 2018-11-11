package org.mql.dao;

import org.mql.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {

	public Menu findByRestaurantId(Long idRestaurant);

}
