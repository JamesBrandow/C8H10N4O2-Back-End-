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

import com.google.gson.Gson;

import devs.c8h10n4o2.entities.Client;
import devs.c8h10n4o2.entities.Pizza;
import devs.c8h10n4o2.entities.Ticket;
import devs.c8h10n4o2.services.ClientService;
import devs.c8h10n4o2.services.PizzaService;
import devs.c8h10n4o2.services.TicketService;



@Component
@Controller
@CrossOrigin("*")
public class TicketController {
	
	@Autowired
	TicketService ts;
	
	@Autowired 
	PizzaService ps;
	
	@Autowired
	ClientService cs;
	
	@ResponseBody
	@RequestMapping(value = "/tickets", method = RequestMethod.POST)
	public Ticket createTicket(@RequestBody String body) {
		
		Gson gson = new Gson();
		Ticket t = gson.fromJson(body, Ticket.class);
		Client c = t.getClient();
		t.setClient(null);
		//System.out.println("Check the incoming ticket from front-end below:");
		//System.out.println(t);
		
		//t.setPlacementTime("asd");
		
		for (Pizza pizza: t.getPizzas()) {
			pizza.setTicket(t);
		}

		
		
		t = ts.createTicket(t); 
		c.getTickets().add(t);
		t.setClient(c);
		

		
		ts.updateTicket(t);
		cs.updateClient(c);
		System.out.println(c);
		
		return t;
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
	@RequestMapping(value = "/updateticket", method = RequestMethod.PUT)
	public Ticket updateTicket(@RequestBody Ticket t) {
		Ticket q = ts.getTicketById(t.getTicketId());
		q.setStatus(t.getStatus());
		return ts.updateTicket(q);
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
	
	@ResponseBody
	@RequestMapping(value = "/tickets/client/{cid}", method = RequestMethod.GET)
	public List<Ticket> getTicketsByClientId(@PathVariable int cid) {
		List<Ticket> tickets = ts.getTicketsByClient(cid);
		return tickets;
	}
	
	
}