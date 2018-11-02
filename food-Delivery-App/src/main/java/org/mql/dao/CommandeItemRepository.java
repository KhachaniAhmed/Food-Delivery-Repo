package org.mql.dao;

import org.mql.entities.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeItemRepository extends JpaRepository<CommandeItem, Long> {

}
