/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.services.banque.api;

import com.c353.bicomat.entities.banque.Client;
import com.c353.bicomat.entities.banque.CompteBancaire;
import java.util.List;

/**
 *
 * @author k.atsou
 */
public interface IBanqueFacade {
    
    List<Client> listeClients();
    
    List<CompteBancaire> listeComptesBancairesClient(Client client);
    
    Client consulterClient(Long id);
    
    boolean compteExiste(CompteBancaire compte);
    
    CompteBancaire consulterCompteBancaire(Long id);
    
}
