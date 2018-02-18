package com.c353.bicomat.entities.banque;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 *
 * @author KAHANAM Essodjolo
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(
//        name = "typeClient",
//        discriminatorType = DiscriminatorType.STRING
//)
public class Client implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idClient;

    @Column
    private String numeroCompte;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private String email;

    @Column(insertable = false, updatable = false)
    private String typeClient;

    @OneToMany
    private List<CompteBancaire> comptesBancaires;

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public List<CompteBancaire> getComptesBancaires() {
        return comptesBancaires;
    }

    public void setComptesBancaires(List<CompteBancaire> comptesBancaires) {
        this.comptesBancaires = comptesBancaires;
    }

    public Long getIdClient() {
        return idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(String typeClient) {
        this.typeClient = typeClient;
    }

    public Client(Long idClient, String nom, String prenom, String email, String typeClient) {
        super();
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.typeClient = typeClient;
    }

    public Client() {
        super();

    }

    public Client(String nomClient, Long idClient) {
        this.nom = nomClient;
        this.idClient = idClient;
    }

}
