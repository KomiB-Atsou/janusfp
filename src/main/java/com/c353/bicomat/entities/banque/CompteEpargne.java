/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.entities.banque;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author k.atsou
 */
@Entity
@DiscriminatorValue("CompteEpargne")
public class CompteEpargne extends CompteBancaire {
    
    @Column
    private double tauxRenumeration;

    public double getTauxRenumeration() {
        return tauxRenumeration;
    }

    public void setTauxRenumeration(double tauxRenumeration) {
        this.tauxRenumeration = tauxRenumeration;
    }
    
}
