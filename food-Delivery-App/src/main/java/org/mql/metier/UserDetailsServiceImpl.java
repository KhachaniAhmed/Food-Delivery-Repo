package org.mql.metier;

import java.util.ArrayList;
import java.util.Collection;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.mql.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private IAccountMetier accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = accountService.findUserByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException(username);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(r -> {
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		System.out
				.println("l'utilisateur qui on a recuperer a partie du font end ***************" + user.getUsername());
		return (UserDetails) new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}

}
