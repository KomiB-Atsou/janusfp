package com.c353.bicomat.entities.banque;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "typeCompte",
        discriminatorType = DiscriminatorType.STRING
)
public class CompteBancaire {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCompte;

    @Column
    private String numeroCompte;

    @Column(insertable = false, updatable = false)
    private String typeCompte;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

//	@Column
//	private boolean decouvert;
//	
//	@Column
//	private double tauxRenumeration;
    @ManyToOne
    @JoinColumn(name = "id_banque")
    private Banque banque;

    public Long getIdCompte() {
        return idCompte;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

//	public boolean isDecouvert() {
//		return decouvert;
//	}
//
//	public void setDecouvert(boolean decouvert) {
//		this.decouvert = decouvert;
//	}
//
//	public double getTauxRenumeration() {
//		return tauxRenumeration;
//	}
//
//	public void setTauxRenumeration(double tauxRenumeration) {
//		this.tauxRenumeration = tauxRenumeration;
//	}
    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public CompteBancaire(Long idCompte, String numeroCompte, String typeCompte, boolean decouvert, double tauxRenumeration) {
        super();
        this.idCompte = idCompte;
        this.numeroCompte = numeroCompte;
        this.typeCompte = typeCompte;
//		this.decouvert = decouvert;
//		this.tauxRenumeration = tauxRenumeration;
    }

    public CompteBancaire() {
        super();

    }

}
