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

    private double solde;

    public CompteTresorerie() {
    }

    public CompteTresorerie(Compte comptePhysique, Compte compteLogique, double solde) {
        this.comptePhysique = comptePhysique;
        this.compteLogique = compteLogique;
        this.solde = solde;
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

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

}
