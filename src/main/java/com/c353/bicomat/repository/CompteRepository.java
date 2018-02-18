/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.repository;

import com.c353.bicomat.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author k.atsou
 */


public interface CompteRepository extends JpaRepository<Compte, Long> {
    
}
