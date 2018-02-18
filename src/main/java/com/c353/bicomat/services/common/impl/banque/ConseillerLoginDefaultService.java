package com.c353.bicomat.services.common.impl.banque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c353.bicomat.entities.agency.ConseillerLogin;
import com.c353.bicomat.repository.agency.ConseillerLoginRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.c353.bicomat.services.common.banque.IConseillerLoginDefaultService;
import com.c353.bicomat.services.common.impl.DefaultService;


/**
 * 
 * @author BOKOBOSSO Eyapene
 *
 */
@Service
public class ConseillerLoginDefaultService extends DefaultService<ConseillerLogin, Integer> implements IConseillerLoginDefaultService {

    @Autowired
    private ConseillerLoginRepository conseillerLoginRepository;

    @Override
    public JpaRepository<ConseillerLogin, Integer> getDao() {
        return conseillerLoginRepository;
    }

}
