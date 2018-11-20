package org.mql.metier;

import javax.transaction.Transactional;

import org.mql.dao.UserRepository;
import org.mql.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserMetierImpl implements IUserMetier {
	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		if (user == null)
			throw new RuntimeException("user invalide ");
		userRepository.save(user);
	}

	@Override
	public User rechercheUserById(Long id) {
		if (id == null)
			throw new RuntimeException("id invalide ");
		return userRepository.getOne(id);
	}

	@Override
	public void modifierUser(User user) {
		if (user == null)
			throw new RuntimeException("user invalide ");
		User oldUser = userRepository.getOne(user.getId());
	}

	@Override
	public void supprimerUser(Long id) {
		if (id == null)
			throw new RuntimeException("id invalide ");
		userRepository.deleteById(id);
	}

}
