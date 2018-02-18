package com.c353.bicomat.entities.agency;

import com.c353.bicomat.entities.banque.ClientInterne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CompteAgency extends ClientInterne {
	
//	@javax.persistence.Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Integer id;
	
	@Column
	private String login;
	
	@Column
	private String motDePasse;
	
	@Column
	private String questionSecrete;
	
	@Column
	private String reponseQuestionSecrete;
	
//	@ManyToOne
//    @JoinColumn( name = "id_client_interne" )
//    private ClientInterne clientInterne;
    
//	public Integer getId() {
//		return id;
//	}
	

//	public ClientInterne getClientInterne() {
//		return clientInterne;
//	}
//
//	public void setClientInterne(ClientInterne clientInterne) {
//		this.clientInterne = clientInterne;
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

	public String getQuestionSecrete() {
		return questionSecrete;
	}

	public void setQuestionSecrete(String questionSecrete) {
		this.questionSecrete = questionSecrete;
	}

	public String getReponseQuestionSecrete() {
		return reponseQuestionSecrete;
	}

	public void setReponseQuestionSecrete(String reponseQuestionSecrete) {
		this.reponseQuestionSecrete = reponseQuestionSecrete;
	}
	

	public CompteAgency(Integer id, String login, String motDePasse, String questionSecrete, String reponseQuestionSecrete) {
		super();
		//this.id = id;
		this.setLogin(login);
		this.setMotDePasse(motDePasse);
		this.setQuestionSecrete(questionSecrete);
		this.setReponseQuestionSecrete(reponseQuestionSecrete);
	}

	public CompteAgency() {
		super();
		
	}

	public CompteAgency(String login, String motDePasse) {
		super();
		this.setLogin(login);
		this.setMotDePasse(motDePasse);
	}
}
