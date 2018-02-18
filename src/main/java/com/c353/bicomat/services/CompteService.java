/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.services;

import com.c353.bicomat.entities.Compte;
import com.c353.bicomat.repository.CompteRepository;
import com.c353.bicomat.services.common.impl.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author k.atsou
 */
    @Service(value = "compteService")
public class CompteService extends DefaultService<Compte, Long> implements ICompteService{
    
    @Autowired
    private CompteRepository compteRepository;

    @Override
    public JpaRepository<Compte, Long> getDao() {
        return compteRepository;
    }

    public void hello(){
        System.out.println("Hello from service");
    }
    
    
}
