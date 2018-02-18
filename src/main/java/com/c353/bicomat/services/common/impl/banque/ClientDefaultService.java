package com.c353.bicomat.services.common.impl.banque;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c353.bicomat.entities.banque.Client;
import com.c353.bicomat.repository.banque.ClientRepository;
import com.c353.bicomat.services.common.banque.IClientDefaultService;


/**
 * 
 * @author KAHANAM Essodjolo
 *
 */
@Service
public class ClientDefaultService implements IClientDefaultService{
	
    /**
     * Injection par Spring
     */
    @Autowired
    private ClientRepository  clientRepository;

	@Override
	public Client saveClient(Client client) {
		
		return clientRepository.save(client);
	}

	@Override
	public Client updateClient(Client client) {
		
		return clientRepository.saveAndFlush(client);
	}

	@Override
	public void deleteClient(Client client) {
		
		 clientRepository.delete(client);
	}

	@Override
	public List<Client> findAllClient() {
	
     return clientRepository.findAll();
		
	}

	@Override
	public Client getUnClient(Long id) {
		
		return clientRepository.findOne(id);
	}


}
