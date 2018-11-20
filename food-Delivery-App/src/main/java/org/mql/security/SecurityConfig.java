package org.mql.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	// dans cette methode on va montrer a spring security comment il va chargé les
	// utilisateurs et les roles
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).
		passwordEncoder(passwordEncoder);

	}

	// dans cette méthode en va définir les droits d'acces et
	// aussi dans cette methode qui on va decider d'ajouter des filtres ou pas
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().
     	loginPage("/login/login");
//		http.authorizeRequests().antMatchers("/login", "/inscrir").permitAll();
//      rederection vers les pages d'errors
//		http.exceptionHandling().accessDeniedPage("403");
		http.authorizeRequests().antMatchers("/cuisines/**").hasAuthority("ADMIN");
		//tous les rousources passe par une authentification  
		http.authorizeRequests().anyRequest().authenticated();
    
	}

}
