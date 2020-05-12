package devs.c8h10n4o2.services;

import java.util.List;

import devs.c8h10n4o2.entities.Client;

public interface ClientServiceI {
	
	Client createClient(Client client);
	Client getClientById(int id);
	Client getClientByUsername(String username);
	List<Client> getAllClient();
	Client updateClient(Client client);
	boolean removeClient(Client client);

}