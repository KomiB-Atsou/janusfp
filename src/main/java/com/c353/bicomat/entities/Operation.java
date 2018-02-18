/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.entities;

import com.c353.bicomat.entities.en.TypeOperationEnum;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author k.atsou
 */

@Entity
public class Operation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    private Date date;
    
    private String libelle;
    
    @ManyToOne
    private Periode periode;
    
    private String commentaires;
  
    @OneToOne
    private Compte compteSourceTresoreriePhysique;
    
    @OneToOne
    private Compte compteSourceTresorerieLogique;
    
    @OneToOne
    private Compte compteSourceStandard;
    
     @OneToOne
    private Compte compteSourceStandardParent;
     
      @OneToOne
    private Compte compteDestinationTresoreriePhysique;
    
    @OneToOne
    private Compte compteDestinationTresorerieLogique;
    
    @OneToOne
    private Compte compteDestinationStandard;
    
     @OneToOne
    private Compte compteDestinationStandardParent;
    
    private int montant;
    
    private TypeOperationEnum typeOperation;
    
    private int nombreMoisEchelonnement;

    public Operation() {
    }

    public Operation(Long Id, Date date, String libelle, String commentaires, Compte compteSourceTresoreriePhysique, Compte compteSourceTresorerieLogique, Compte compteSourceStandard, Compte compteSourceStandardParent, Compte compteDestinationTresoreriePhysique, Compte compteDestinationTresorerieLogique, Compte compteDestinationStandard, Compte compteDestinationStandardParent, int montant, TypeOperationEnum typeOperation) {
        this.Id = Id;
        this.date = date;
        this.libelle = libelle;
        this.commentaires = commentaires;
        this.compteSourceTresoreriePhysique = compteSourceTresoreriePhysique;
        this.compteSourceTresorerieLogique = compteSourceTresorerieLogique;
        this.compteSourceStandard = compteSourceStandard;
        this.compteSourceStandardParent = compteSourceStandardParent;
        this.compteDestinationTresoreriePhysique = compteDestinationTresoreriePhysique;
        this.compteDestinationTresorerieLogique = compteDestinationTresorerieLogique;
        this.compteDestinationStandard = compteDestinationStandard;
        this.compteDestinationStandardParent = compteDestinationStandardParent;
        this.montant = montant;
        this.typeOperation = typeOperation;
    }

    public Operation(String libelle, Compte compteSourceTresoreriePhysique, Compte compteSourceTresorerieLogique, Compte compteSourceStandard, Compte compteSourceStandardParent, Compte compteDestinationTresoreriePhysique, Compte compteDestinationTresorerieLogique, Compte compteDestinationStandard, Compte compteDestinationStandardParent, int montant, TypeOperationEnum typeOperation) {
        this.libelle = libelle;
        this.compteSourceTresoreriePhysique = compteSourceTresoreriePhysique;
        this.compteSourceTresorerieLogique = compteSourceTresorerieLogique;
        this.compteSourceStandard = compteSourceStandard;
        this.compteSourceStandardParent = compteSourceStandardParent;
        this.compteDestinationTresoreriePhysique = compteDestinationTresoreriePhysique;
        this.compteDestinationTresorerieLogique = compteDestinationTresorerieLogique;
        this.compteDestinationStandard = compteDestinationStandard;
        this.compteDestinationStandardParent = compteDestinationStandardParent;
        this.montant = montant;
        this.typeOperation = typeOperation;
    }
    
    

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public Compte getCompteSourceTresoreriePhysique() {
        return compteSourceTresoreriePhysique;
    }

    public void setCompteSourceTresoreriePhysique(Compte compteSourceTresoreriePhysique) {
        this.compteSourceTresoreriePhysique = compteSourceTresoreriePhysique;
    }

    public Compte getCompteSourceTresorerieLogique() {
        return compteSourceTresorerieLogique;
    }

    public void setCompteSourceTresorerieLogique(Compte compteSourceTresorerieLogique) {
        this.compteSourceTresorerieLogique = compteSourceTresorerieLogique;
    }

    public Compte getCompteSourceStandard() {
        return compteSourceStandard;
    }

    public void setCompteSourceStandard(Compte compteSourceStandard) {
        this.compteSourceStandard = compteSourceStandard;
    }

    public Compte getCompteSourceStandardParent() {
        return compteSourceStandardParent;
    }

    public void setCompteSourceStandardParent(Compte compteSourceStandardParent) {
        this.compteSourceStandardParent = compteSourceStandardParent;
    }

    public Compte getCompteDestinationTresoreriePhysique() {
        return compteDestinationTresoreriePhysique;
    }

    public void setCompteDestinationTresoreriePhysique(Compte compteDestinationTresoreriePhysique) {
        this.compteDestinationTresoreriePhysique = compteDestinationTresoreriePhysique;
    }

    public Compte getCompteDestinationTresorerieLogique() {
        return compteDestinationTresorerieLogique;
    }

    public void setCompteDestinationTresorerieLogique(Compte compteDestinationTresorerieLogique) {
        this.compteDestinationTresorerieLogique = compteDestinationTresorerieLogique;
    }

    public Compte getCompteDestinationStandard() {
        return compteDestinationStandard;
    }

    public void setCompteDestinationStandard(Compte compteDestinationStandard) {
        this.compteDestinationStandard = compteDestinationStandard;
    }

    public Compte getCompteDestinationStandardParent() {
        return compteDestinationStandardParent;
    }

    public void setCompteDestinationStandardParent(Compte compteDestinationStandardParent) {
        this.compteDestinationStandardParent = compteDestinationStandardParent;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public TypeOperationEnum getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperationEnum typeOperation) {
        this.typeOperation = typeOperation;
    }

    public int getNombreMoisEchelonnement() {
        return nombreMoisEchelonnement;
    }

    public void setNombreMoisEchelonnement(int nombreMoisEchelonnement) {
        this.nombreMoisEchelonnement = nombreMoisEchelonnement;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }
    
}
