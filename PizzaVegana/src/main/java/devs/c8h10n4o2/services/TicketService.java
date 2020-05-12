package devs.c8h10n4o2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import devs.c8h10n4o2.entities.Client;
import devs.c8h10n4o2.entities.Ticket;
import devs.c8h10n4o2.repositories.ClientRepository;
import devs.c8h10n4o2.repositories.PizzaRepository;
import devs.c8h10n4o2.repositories.TicketRepository;

@Component
@Service
public class TicketService implements TicketServiceI{
	
	@Autowired
	PizzaRepository ps;
	
	@Autowired
	TicketRepository tr;
	
	@Autowired
	ClientRepository cr;
	
	@Override
	public Ticket createTicket(Ticket t) {
		t = tr.save(t);
		//System.out.println("Check this ticket id:"+t.getTicketId());
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
	
	@Override
	public List<Ticket> getTicketsByClient(int id) {
		Client c = cr.findById(id).get();
		List<Ticket> tickets = (List<Ticket>) tr.findByClient(c);
		return tickets;
	}

	
}