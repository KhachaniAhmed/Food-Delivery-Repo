package org.mql.dao;


import java.util.List;

import org.mql.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface MenuRepository extends JpaRepository<Menu, Long> {
<<<<<<< HEAD
	public Menu findByNom(String nom);
	@Query("select r from Menu r where r.restaurant.id=:x")
	public List<Menu> rerchercheParId(@Param("x")Long id);
	
=======

	public Menu findByRestaurantId(Long idRestaurant);

>>>>>>> refs/remotes/origin/master
}
