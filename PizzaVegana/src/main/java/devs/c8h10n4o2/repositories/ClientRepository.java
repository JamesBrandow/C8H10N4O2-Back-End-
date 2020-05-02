package devs.c8h10n4o2.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import devs.c8h10n4o2.entities.Client;

import org.springframework.data.repository.CrudRepository;

@Component
@Repository

public interface ClientRepository extends CrudRepository<Client, Integer>{
	
	Client findByUsername(String username);

}
