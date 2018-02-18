package com.c353.bicomat.services.agency.impl;

import java.util.List;

import com.c353.bicomat.entities.banque.Banque;
import com.c353.bicomat.entities.banque.Client;
import com.c353.bicomat.entities.agency.CompteAgency;
import com.c353.bicomat.services.agency.api.IAgencyAdminService;
import com.c353.bicomat.services.common.agency.ICompteAgencyDefaultService;
import javax.inject.Inject;

public class AgencyAdminService implements IAgencyAdminService {
    
    @Inject
    private ICompteAgencyDefaultService compteAgencyDefaultService;

    @Override
    public void creerCompteAgencyProvisoire(Client client, String questionSecrete, String reponseQuestionSecrete) {
        compteAgencyDefaultService.ajouter(new CompteAgency(questionSecrete, reponseQuestionSecrete));

    }

    @Override
    public void validerCompteAgencyProvisoire(CompteAgency clientInterneAgency) {
        // TODO Auto-generated method stub

    }

    @Override
    public CompteAgency consulterCompteAgency(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CompteAgency> listerComptesAgency() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ICompteAgencyDefaultService getCompteAgencyDefaultService() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return compteAgencyDefaultService;
    }

}
