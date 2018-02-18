package com.c353.bicomat.entities.banque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 *
 * @author KAHANAM Essodjolo
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorValue("ClientInterne")
public class ClientInterne extends Client {

//	@javax.persistence.Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
    @Column
    private Date anneeArrivee;

    @Column
    private String numeroContrat;

    @Column
    private Boolean agency;

    @Column
    private String numeroPortable;

//    @OneToOne
//    @JoinColumn(name = "id_client")
//    private Client client;

//	public Long getId() {
//		return id;
//	}
    public Date getAnneeArrivee() {
        return anneeArrivee;
    }

    public void setAnneeArrivee(Date anneeArrivee) {
        this.anneeArrivee = anneeArrivee;
    }

    public String getNumeroContrat() {
        return numeroContrat;
    }

    public void setNumeroContrat(String numeroContrat) {
        this.numeroContrat = numeroContrat;
    }

    public Boolean getAgency() {
        return agency;
    }

    public void setAgency(Boolean agency) {
        this.agency = agency;
    }

    public String getNumeroPortable() {
        return numeroPortable;
    }

    public void setNumeroPortable(String numeroPortable) {
        this.numeroPortable = numeroPortable;
    }

//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }

    public ClientInterne(Long id, Date anneeArrivee, String numeroContrat, Boolean agency, String numeroPortable) {
        super();
        // this.id = id;
        this.anneeArrivee = anneeArrivee;
        this.numeroContrat = numeroContrat;
        this.agency = agency;
        this.numeroPortable = numeroPortable;
    }

    public ClientInterne() {
        super();
    }

}
