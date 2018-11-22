package org.mql.dao;


import java.util.List;

import org.mql.entities.Adresse;
import org.mql.entities.Menu;
import org.mql.entities.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface MenuRepository extends JpaRepository<Menu, Long> {

	public Menu findByNom(String nom);
	@Query("select m from Menu m where m.restaurant.id=:x")
	public List<Menu> rerchercheParId(@Param("x")Long id);
	
	@Query("select m from Menu m where m.nom like :x ")
	Page<Menu>cherche(@Param("x")String mc,Pageable pageable);
	//public Menu findByRestaurantId(Long id);


}
