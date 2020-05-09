package devs.c8h10n4o2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import devs.c8h10n4o2.entities.Ticket;
import devs.c8h10n4o2.repositories.PizzaRepository;
import devs.c8h10n4o2.repositories.TicketRepository;

@Component
@Service
public class TicketService implements TicketServiceI{
	
	@Autowired
	PizzaRepository ps;
	
	@Autowired
	TicketRepository tr;
	
	@Override
	public Ticket createTicket(Ticket t) {
		t = tr.save(t);
		return t;
	}

	@Override
	public Ticket getTicketById(int id) {
		
		return tr.findById(id).get();
	}

	@Override
	public List<Ticket> getAllTickets() {
		List<Ticket> tickets = (List<Ticket>) tr.findAll();
		return tickets;
	}

	@Override
	public Ticket updateTicket(Ticket t) {
		
		return tr.save(t);
	}
	
	@Override
	public boolean deleteTicket(Ticket t) {
		try {
			tr.delete(t);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	
}