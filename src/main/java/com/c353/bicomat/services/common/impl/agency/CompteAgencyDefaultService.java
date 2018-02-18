package com.c353.bicomat.services.common.impl.agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c353.bicomat.entities.agency.CompteAgency;
import com.c353.bicomat.repository.agency.CompteAgencyRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.c353.bicomat.services.common.agency.ICompteAgencyDefaultService;
import com.c353.bicomat.services.common.impl.DefaultService;

/**
 *
 * @author KAHANAM Essodjolo
 *
 */
@Service
public class CompteAgencyDefaultService extends DefaultService<CompteAgency, Integer> implements ICompteAgencyDefaultService {

    @Autowired
    private CompteAgencyRepository compteAgencyRepository;

    @Override
    public JpaRepository<CompteAgency, Integer> getDao() {
        return compteAgencyRepository;
    }

}
