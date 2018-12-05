package org.mql.metier;

import org.mql.dao.CommandeItemRepository;
import org.mql.entities.CommandeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommandeItemImpl implements ICommandeItemMetier {
	@Autowired
	CommandeItemRepository commandeItemRepositor;

	@Override
	public CommandeItem addCommandeItem(CommandeItem commandeItem) {
		this.commandeItemRepositor.save(commandeItem);
		return commandeItem;
	}

}
