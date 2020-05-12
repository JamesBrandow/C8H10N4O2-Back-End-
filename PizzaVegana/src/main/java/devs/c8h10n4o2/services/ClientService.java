package devs.c8h10n4o2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import devs.c8h10n4o2.entities.Client;
import devs.c8h10n4o2.repositories.ClientRepository;

@Component
@Service 

public class ClientService implements ClientServiceI {

	@Autowired
	ClientRepository cr;

	@Override
	public Client createClient(Client client) {
		client = cr.save(client);
		return client;
	} 

	@Override
	public Client getClientById(int id) {
		return cr.findById(id).get();
	}

	@Override
	public Client getClientByUsername(String username) {
		return cr.findByUsername(username);
	}

	@Override
	public List<Client> getAllClient() {
		List<Client> clients = (List<Client>) cr.findAll();
		return clients;
	}

	@Override
	public Client updateClient(Client client) {
		return cr.save(client);
	}

	@Override
	public boolean removeClient(Client client) {
		try {
			cr.delete(client);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}