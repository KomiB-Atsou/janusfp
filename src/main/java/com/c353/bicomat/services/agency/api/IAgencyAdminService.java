package com.c353.bicomat.services.agency.api;

import java.util.List;

import com.c353.bicomat.entities.banque.Banque;
import com.c353.bicomat.entities.banque.Client;
import com.c353.bicomat.entities.agency.CompteAgency;
import com.c353.bicomat.services.common.agency.ICompteAgencyDefaultService;
import javax.inject.Inject;

/**
 * Interface pour l'administration des comptes Agency.
 *
 * @author ATSOU Komi Bi-Ayéfo
 *
 */
public interface IAgencyAdminService {
    

    void creerCompteAgencyProvisoire(Client client,
            String questionSecrete,
            String reponseQuestionSecrete);

    void validerCompteAgencyProvisoire(CompteAgency clientInterneAgency);

    CompteAgency consulterCompteAgency(Long id);

    List<CompteAgency> listerComptesAgency();
    
    ICompteAgencyDefaultService getCompteAgencyDefaultService();

}
