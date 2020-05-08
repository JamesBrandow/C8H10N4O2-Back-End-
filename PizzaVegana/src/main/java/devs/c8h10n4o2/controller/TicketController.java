package devs.c8h10n4o2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import devs.c8h10n4o2.entities.Ticket;
import devs.c8h10n4o2.services.TicketService;



@Component
@Controller
@CrossOrigin("*")
public class TicketController {
	@Autowired
	TicketService ts;
	
	
	@ResponseBody
	@RequestMapping(value = "/tickets", method = RequestMethod.POST)
	public Ticket createTicket(@RequestBody Ticket t) {
		System.out.println(t);
		return ts.createTicket(t); 
	}
	
	@ResponseBody
	@RequestMapping(value = "/tickets/{id}", method = RequestMethod.GET)
	public Ticket getTicketById(@PathVariable int id) {
		
		return ts.getTicketById(id);
	} 
	
	@ResponseBody
	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public List<Ticket> getAllTickets(){
		List<Ticket> tickets = ts.getAllTickets();
		return tickets;
	}
	
	@ResponseBody
	@RequestMapping(value = "/tickets", method = RequestMethod.PUT)
	public Ticket updateTicket(@RequestBody Ticket t) {
		
		return ts.updateTicket(t);
	}
	
	@ResponseBody
	@RequestMapping(value = "/tickets", method = RequestMethod.DELETE)
	public boolean deleteTicket(Ticket t) {
		boolean result = ts.deleteTicket(t);
		if(result == false) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Did not delete");
		}
		
		return result;
	}
	
	
}