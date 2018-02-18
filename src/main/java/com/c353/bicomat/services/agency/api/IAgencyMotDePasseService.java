package com.c353.bicomat.services.agency.api;

import com.c353.bicomat.entities.banque.Client;
import com.c353.bicomat.entities.agency.CompteAgency;

/**
 * Interface pour la gestion des mots de passe de comptes Agency.
 *
 * @author KAHANAM Essodjolo
 *
 */
public interface IAgencyMotDePasseService {

    void restaurerMotDePasseAgency(CompteAgency compteAgency);

}
