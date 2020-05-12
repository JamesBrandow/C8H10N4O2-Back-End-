  
package devs.c8h10n4o2.services;

import java.util.List;

import devs.c8h10n4o2.entities.Ticket;

public interface TicketServiceI {
	
	Ticket createTicket(Ticket t);
	
	Ticket getTicketById(int id);
	List<Ticket> getAllTickets();
	List<Ticket> getTicketsByClient(int id);
	
	Ticket updateTicket(Ticket t);
	
	boolean deleteTicket(Ticket t);

}