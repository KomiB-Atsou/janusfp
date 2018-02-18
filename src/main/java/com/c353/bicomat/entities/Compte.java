/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.entities;

import com.c353.bicomat.entities.en.FormeCompteEnum;
import com.c353.bicomat.entities.en.TypeCompteEnum;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author k.atsou
 */
@Entity
public class Compte implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    private String libelle;

    private String description;

    private double soldeInitial;

    private double soldeCourant;

    private boolean mouvementable;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDerniereMaj;

    private TypeCompteEnum typeCompte;

    private FormeCompteEnum formeCompte;

    @ManyToOne
    private Compte compteParent;

    @OneToMany(mappedBy = "compteParent", fetch = FetchType.EAGER)
    private List<Compte> comptesEnfants;

    @OneToMany(fetch = FetchType.EAGER)
    private List<CompteTresorerie> comptesTresorerie;

    public Compte(String code, String libelle, double soldeInitial,
            double soldeCourant, boolean mouvementable, Date dateCreation,
            Date dateDerniereMaj, TypeCompteEnum typeCompte,
            FormeCompteEnum formeCompte) {
        this.code = code;
        this.libelle = libelle;
        this.soldeInitial = soldeInitial;
        this.soldeCourant = soldeCourant;
        this.mouvementable = mouvementable;
        this.dateCreation = dateCreation;
        this.dateDerniereMaj = dateDerniereMaj;
        this.typeCompte = typeCompte;
        this.formeCompte = formeCompte;
    }

    public Compte() {
    }

    public Compte(String libelle, double soldeCourant) {
        this.libelle = libelle;
        this.soldeCourant = soldeCourant;
    }

    public Compte(String libelle, double soldeCourant, TypeCompteEnum type, FormeCompteEnum forme, boolean mouvementable) {
        this.libelle = libelle;
        this.soldeCourant = soldeCourant;
        this.typeCompte = type;
        this.formeCompte = forme;
        this.mouvementable = mouvementable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getSoldeInitial() {
        return soldeInitial;
    }

    public void setSoldeInitial(double soldeInitial) {
        this.soldeInitial = soldeInitial;
    }

    public double getSoldeCourant() {
        double l_soldeCourant = 0.0;

        // Solde courant comme somme des soldes des comptes enfants
        // Si le compte n'a pas d'enfants, alors il est mouvementable
        if (!this.isMouvementable()) {
            
            List<Compte> enfants = this.getComptesEnfants();
            for (Compte enfant : enfants) {
                l_soldeCourant += enfant.getSoldeCourant();
            }
        }else{
            l_soldeCourant = soldeCourant;
        }
        // Si ce compte est un compte phyique
        // Solde courant comme somme des comptes logiques en lien
        if (this.getFormeCompte() == FormeCompteEnum.PHYSIQUE) {
            List<CompteTresorerie> comptesTresorerie = this.getComptesTresorerie();
            if (!comptesTresorerie.isEmpty()) {
                for (CompteTresorerie compteTreso : comptesTresorerie) {
                    if (compteTreso.getComptePhysique().getId() == this.getId()) {
                        l_soldeCourant += compteTreso.getSoldeCourant();
                    }
                }
            }
//            else{
//                l_soldeCourant = 0;
//            }

        }
        // Si ce compte est un compte logique
        // Solde courant comme somme des comptes physiques en lien
        if (this.getFormeCompte() == FormeCompteEnum.LOGIQUE) {
            List<CompteTresorerie> comptesTresorerie = this.getComptesTresorerie();
            for (CompteTresorerie compteTreso : comptesTresorerie) {
                if (compteTreso.getCompteLogique().getId() == this.getId()) {
                    l_soldeCourant += compteTreso.getSoldeCourant();
                }

            }
        }

        return l_soldeCourant;
    }

    public List<Compte> getComptesPhysiquesEnLien() {
        List<CompteTresorerie> comptesTresorerie = this.getComptesTresorerie();
        List<Compte> comptesPhysiquesEnLien = null;
        if (this.getFormeCompte() == FormeCompteEnum.LOGIQUE) {
            for (CompteTresorerie compteTreso : comptesTresorerie) {
                if (compteTreso.getCompteLogique().getId() == this.getId()) {
                    comptesPhysiquesEnLien.add(compteTreso.getComptePhysique());
                }
            }
        }
        return comptesPhysiquesEnLien;
    }

    public List<Compte> getComptesLogiquesEnLien() {
        List<CompteTresorerie> comptesTresorerie = this.getComptesTresorerie();
        List<Compte> comptesLogiquesEnLien = null;
        if (this.getFormeCompte() == FormeCompteEnum.PHYSIQUE) {
            for (CompteTresorerie compteTreso : comptesTresorerie) {
                if (compteTreso.getComptePhysique().getId() == this.getId()) {
                    comptesLogiquesEnLien.add(compteTreso.getCompteLogique());
                }
            }
        }
        return comptesLogiquesEnLien;
    }

    public double getSoldeCompteLogiqueEnLienAUnComptePhysique(Compte compteLogique) {
        double solde = 0;
        // On suppose qu'il s'agit d'un compte physique
        List<CompteTresorerie> comptesTresorerie = this.getComptesTresorerie();
        if (this.getFormeCompte() == FormeCompteEnum.PHYSIQUE) {
            for (CompteTresorerie compteTreso : comptesTresorerie) {
                if (compteTreso.getComptePhysique().getId() == this.getId()
                        && compteTreso.getCompteLogique().getId()
                        == compteLogique.getId()) {
                    solde = compteTreso.getSoldeCourant();
                }
            }
        }
        return solde;
    }

    public double getSoldeComptePhyiqueEnLienAUnCompteLogique(Compte comptePhysique) {
        double solde = 0;
        // On suppose qu'il s'agit d'un compte physique
        List<CompteTresorerie> comptesTresorerie = this.getComptesTresorerie();
        if (this.getFormeCompte() == FormeCompteEnum.LOGIQUE) {
            for (CompteTresorerie compteTreso : comptesTresorerie) {
                if (compteTreso.getCompteLogique().getId() == this.getId()
                        && compteTreso.getComptePhysique().getId()
                        == comptePhysique.getId()) {
                    solde = compteTreso.getSoldeCourant();
                }
            }
        }
        return solde;
    }

    // Cette opération devrait être réalisée avec prudence
    public void setSoldeCourant(double soldeCourant) {
        this.soldeCourant = soldeCourant;
    }

    public boolean isMouvementable() {
        return mouvementable;
    }

    public void setMouvementable(boolean mouvementable) {
        this.mouvementable = mouvementable;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateDerniereMaj() {
        return dateDerniereMaj;
    }

    public void setDateDerniereMaj(Date dateDerniereMaj) {
        this.dateDerniereMaj = dateDerniereMaj;
    }

    public TypeCompteEnum getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(TypeCompteEnum typeCompte) {
        this.typeCompte = typeCompte;
    }

    public FormeCompteEnum getFormeCompte() {
        return formeCompte;
    }

    public void setFormeCompte(FormeCompteEnum formeCompte) {
        this.formeCompte = formeCompte;
    }

    public Compte getCompteParent() {
        return compteParent;
    }

    public void setCompteParent(Compte compteParent) {
        this.compteParent = compteParent;
    }

    public List<Compte> getComptesEnfants() {
        return comptesEnfants;
    }

    public void setComptesEnfants(List<Compte> comptesEnfants) {
        // Si le compte n'est pas mouvementable, alors il a des enfants
        if (!this.isMouvementable()) {
            this.comptesEnfants = comptesEnfants;
        }

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CompteTresorerie> getComptesTresorerie() {
        return comptesTresorerie;
    }

    public void setComptesTresorerie(List<CompteTresorerie> comptesTresorerie) {
        this.comptesTresorerie = comptesTresorerie;
    }

    public String toString() {
        return "Libellé : " + this.getLibelle() + ", Solde Initial : " + this.getSoldeInitial();
    }

}
