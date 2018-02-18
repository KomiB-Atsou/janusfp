package com.c353.bicomat.services.common.impl.banque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c353.bicomat.entities.banque.Banque;
import com.c353.bicomat.repository.banque.BanqueRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.c353.bicomat.services.common.banque.IBanqueDefaultService;
import com.c353.bicomat.services.common.impl.DefaultService;

/**
 *
 * @author DINAH Aladji Jérémie
 *
 */
@Service(value = "banqueDefaultService")
public class BanqueDefaultService extends DefaultService<Banque, Integer> implements IBanqueDefaultService {

    @Autowired
    private BanqueRepository banqueRepository;

    @Override
    public JpaRepository<Banque, Integer> getDao() {
        return banqueRepository;
    }
    
    
    public void testFromBanque(){
        System.out.println("Test from Banque Service");
    }

}
