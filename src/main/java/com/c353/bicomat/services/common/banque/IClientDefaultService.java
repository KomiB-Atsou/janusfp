package com.c353.bicomat.services.common.banque;

import java.util.List;

import com.c353.bicomat.entities.banque.Client;

/**
 * 
 * @author KAHANAM Essodjolo
 *
 */
public interface IClientDefaultService {
	
	public Client saveClient(Client client);

	public Client updateClient(Client client);

	public void deleteClient(Client client);

	public List<Client> findAllClient();

	public Client getUnClient(Long id);

}
