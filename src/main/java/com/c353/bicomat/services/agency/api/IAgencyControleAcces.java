/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.services.agency.api;

import com.c353.bicomat.entities.agency.CompteAgency;

/**
 *
 * @author k.atsou
 */
public interface IAgencyControleAcces {
    
    void annulerAccesAgency(CompteAgency compteAgency);
    
    Boolean connexionAgency(String login, String motDePasse);
    
}
