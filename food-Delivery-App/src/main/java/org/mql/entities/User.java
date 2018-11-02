package org.mql.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	private String nom;
	private String prenom;
	private String tel;
	private String genre;
	private LocalDate dateNaissance;
	private boolean blocked;
	private int nbrCnx;
	private boolean mdpChanger;
	private int isAdmine;
	@ManyToOne
	private Adresse adresse; 
	@OneToOne(mappedBy="adminRestau")
	private Restaurant restaurant;
   
}
