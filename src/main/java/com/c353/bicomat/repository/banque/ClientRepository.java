package com.c353.bicomat.repository.banque;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c353.bicomat.entities.banque.Client;

/**
 * 
 * @author KAHANAM Essodjolo
 *
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

}
