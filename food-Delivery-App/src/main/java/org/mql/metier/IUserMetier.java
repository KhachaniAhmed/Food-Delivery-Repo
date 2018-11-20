package org.mql.metier;

import org.mql.entities.User;

public interface IUserMetier {
	public void saveUser(User user);

	public User rechercheUserById(Long id);

	public void modifierUser(User user);

	public void supprimerUser(Long id);

}
