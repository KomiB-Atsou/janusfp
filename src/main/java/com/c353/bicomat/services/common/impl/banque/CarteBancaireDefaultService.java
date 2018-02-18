package com.c353.bicomat.services.common.impl.banque;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.c353.bicomat.entities.banque.CarteBancaire;
import com.c353.bicomat.repository.banque.CarteBancaireRepository;
import com.c353.bicomat.services.common.banque.ICarteBancaireDefaultService;
import com.c353.bicomat.services.common.impl.DefaultService;

/**
 * 
 * @author KAHANAM Essodjolo
 *
 */
@Service
public class CarteBancaireDefaultService extends DefaultService<CarteBancaire, Integer>  implements ICarteBancaireDefaultService{

    @Autowired
    private CarteBancaireRepository carteBancaireRepository;

    @Override
    public JpaRepository<CarteBancaire, Integer> getDao() {
        return carteBancaireRepository;
    }

}
