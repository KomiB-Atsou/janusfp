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
@DiscriminatorValue("CompteCourant")
public class CompteCourant extends CompteBancaire {
    
    	@Column
	private boolean decouvert;

    public boolean isDecouvert() {
        return decouvert;
    }

    public void setDecouvert(boolean decouvert) {
        this.decouvert = decouvert;
    }
    
}
