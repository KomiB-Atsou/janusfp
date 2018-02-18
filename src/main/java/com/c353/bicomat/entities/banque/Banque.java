package com.c353.bicomat.entities.banque;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Classe entité pour Banque.
 *
 * @author DINAH Aladji Jérémie
 *
 */
@Entity
public class Banque implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idBanque;

    @Column
    private String nom;

    @Column
    private String adresse;

    public Integer getIdBanque() {
        return idBanque;
    }

    public void setIdBanque(Integer idBanque) {
        this.idBanque = idBanque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Banque(Integer idBanque, String nom, String adresse) {
        super();
        this.idBanque = idBanque;
        this.nom = nom;
        this.adresse = adresse;
    }

    public Banque() {
        super();

    }

}
