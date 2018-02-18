package com.c353.bicomat.entities.agency;

import com.c353.bicomat.entities.banque.Conseiller;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author BOKOBOSSO Eyapene
 *
 */

@Entity
public class ConseillerLogin extends Conseiller {
//extends Conseiller {
	
//	@javax.persistence.Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
	
	@Column
	private String login;
	
	@Column
	private String motDePasse;
		
//	@ManyToOne
//    @JoinColumn( name = "id_conseiller" )
//    private Conseiller conseiller;
	
	
//	public Long getId() {
//		return id;
//	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

//	public Conseiller getConseiller() {
//		return conseiller;
//	}

//	public void setConseiller(Conseiller conseiller) {
//		this.conseiller = conseiller;
//	}
	
	public ConseillerLogin(Long id, String login, String motDePasse) {
		super();
		//this.id = id;
		this.login = login;
		this.motDePasse = motDePasse;
	}

	public ConseillerLogin() {
		super();
	}
}