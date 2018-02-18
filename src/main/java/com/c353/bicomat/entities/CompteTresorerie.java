/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

/**
 *
 * @author k.atsou
 */
@Entity
public class CompteTresorerie {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Compte comptePhysique;

    @ManyToOne
    private Compte compteLogique;

    private double soldeInitial;
    
    private double soldeCourant;

    public CompteTresorerie() {
    }

    public CompteTresorerie(Compte comptePhysique, Compte compteLogique, double soldeInitial) {
        this.comptePhysique = comptePhysique;
        this.compteLogique = compteLogique;
        this.soldeInitial = soldeInitial;
        this.soldeCourant = this.soldeInitial;
    }

    public Compte getComptePhysique() {
        return comptePhysique;
    }

    public void setComptePhysique(Compte comptePhysique) {
        this.comptePhysique = comptePhysique;
    }

    public Compte getCompteLogique() {
        return compteLogique;
    }

    public void setCompteLogique(Compte compteLogique) {
        this.compteLogique = compteLogique;
    }

    public double getSoldeInitial() {
        return soldeInitial;
    }

    public void setSoldeInitial(double soldeInitial) {
        this.soldeInitial = soldeInitial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSoldeCourant() {
        return soldeCourant;
    }

    public void setSoldeCourant(double soldeCourant) {
        this.soldeCourant = soldeCourant;
    }

}
