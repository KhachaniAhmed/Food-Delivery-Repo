package org.mql.metier;

import java.util.List;

import org.mql.entities.Commande;
import org.mql.entities.CommandeItem;

public interface ICommandeMetier {
	public Commande addCommande(Commande commande);
	public void addCommandeItem(Commande commande, List<CommandeItem> commandeItem);

}
