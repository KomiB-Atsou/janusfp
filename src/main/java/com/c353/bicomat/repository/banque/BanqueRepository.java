package com.c353.bicomat.repository.banque;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c353.bicomat.entities.banque.Banque;
import org.springframework.stereotype.Service;

/**
 * 
 * @author DINAH Aladji Jérémie
 *
 */

public interface BanqueRepository extends JpaRepository<Banque, Integer> {

}
