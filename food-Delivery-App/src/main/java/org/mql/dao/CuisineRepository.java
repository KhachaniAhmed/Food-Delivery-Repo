package org.mql.dao;

import org.mql.entities.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuisineRepository extends JpaRepository<Cuisine , Long> {

}
