package org.mql.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nom;
	@OneToOne
	private User adminRestau;
	@OneToMany(mappedBy = "restaurant",fetch=FetchType.EAGER)
	private List<Commande> commandes=new ArrayList<>();
	@OneToOne
	private Adresse adresse;
	@OneToOne(mappedBy = "restaurant")
	private Menu menu;
	public Restaurant(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
}
