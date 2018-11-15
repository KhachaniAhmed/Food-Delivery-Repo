package org.mql.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	private String nom;
	private String prenom;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	//private int isAdmine;
	@ManyToOne
	private Adresse adresse; 
	@OneToOne(mappedBy="adminRestau")
	private Restaurant restaurant;
	
	public User(Long id, String email, String password, String nom, String prenom, Date dateNaissance,
			Adresse adresse) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
	}

	public User(Long id, String email, String password, String nom, String prenom, Date dateNaissance) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}
   
}
