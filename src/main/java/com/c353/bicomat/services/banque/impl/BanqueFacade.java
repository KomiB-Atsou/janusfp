/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.services.banque.impl;

import com.c353.bicomat.entities.banque.Client;
import com.c353.bicomat.entities.banque.CompteBancaire;
import com.c353.bicomat.services.banque.api.IBanqueFacade;
import java.util.List;

/**
 *
 * @author k.atsou
 */
public class BanqueFacade implements IBanqueFacade {

    @Override
    public List<Client> listeClients() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CompteBancaire> listeComptesBancairesClient(Client client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client consulterClient(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean compteExiste(CompteBancaire compte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompteBancaire consulterCompteBancaire(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
