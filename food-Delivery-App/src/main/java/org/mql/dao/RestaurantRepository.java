package org.mql.dao;

import java.util.List;

import org.mql.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	@Query("select r from Restaurant r where r.adresse.id=:x")
    public List<Restaurant> getRestaurantsByAdresse(@Param("x") Long id);

}
