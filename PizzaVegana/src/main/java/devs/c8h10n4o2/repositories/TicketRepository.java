package devs.c8h10n4o2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import devs.c8h10n4o2.entities.Client;
import devs.c8h10n4o2.entities.Ticket;

@Component
@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer>{
	List<Ticket> findByClient(Client c);
}