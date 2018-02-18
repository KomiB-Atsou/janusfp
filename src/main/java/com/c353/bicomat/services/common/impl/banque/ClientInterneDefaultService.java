package com.c353.bicomat.services.common.impl.banque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c353.bicomat.entities.banque.ClientInterne;
import com.c353.bicomat.repository.banque.ClientInterneRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.c353.bicomat.services.common.banque.IClientInterneDefaultService;
import com.c353.bicomat.services.common.impl.DefaultService;

/**
 *
 * @author KAHANAM Essodjolo
 *
 */
@Service
public class ClientInterneDefaultService extends DefaultService<ClientInterne, Integer> implements IClientInterneDefaultService {

    @Autowired
    private ClientInterneRepository clientInterneRepository;

    @Override
    public JpaRepository<ClientInterne, Integer> getDao() {
        return clientInterneRepository;
    }

}
