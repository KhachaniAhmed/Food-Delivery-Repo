package org.mql.metier;

import java.util.List;

import org.mql.dao.CommandeRepository;
import org.mql.entities.Commande;
import org.mql.entities.CommandeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommandeImpl implements ICommandeMetier {
	@Autowired
	CommandeRepository commandeRepository;

	@Override
	public Commande addCommande(Commande commande) {
		this.commandeRepository.save(commande);
		return commande;
	}

	@Override
	public void addCommandeItem(Commande commande, List<CommandeItem> commandeItem) {
		Commande commandeUpdate = commandeRepository.getOne(commande.getId());
		commandeUpdate.setCommandeItems(commandeItem);
		this.commandeRepository.save(commandeUpdate);
	}

}
