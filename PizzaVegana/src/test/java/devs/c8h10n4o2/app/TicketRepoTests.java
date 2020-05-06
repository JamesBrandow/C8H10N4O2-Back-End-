package devs.c8h10n4o2.app;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import devs.c8h10n4o2.entities.Ticket;
import devs.c8h10n4o2.repositories.ClientRepository;
import devs.c8h10n4o2.repositories.TicketRepository;

@SpringBootTest
@ContextConfiguration(classes = devs.c8h10n4o2.app.PizzaVeganaApplication.class)
public class TicketRepoTests {
	@Autowired
	TicketRepository tr;
	
	@Autowired
	ClientRepository cr;
	
	@Test
	void createTicketTest() {
		Ticket test = new Ticket();
		test.setPlacementTime("11:00");
		test.setStatus("preparing");
		test.setNote("test from Java");
		test.setCost(0);
		test.setClient(cr.findById(1).get());
		tr.save(test);
		System.out.println("============");
		System.out.println(test);
		System.out.println("============");
	}
	
	@Test
	void getAllTickets() {
		List<Ticket> tickets = (List<Ticket>) tr.findAll();
		System.out.println("============");
		for(Ticket ticket : tickets) {
			System.out.println(ticket);
		}
		System.out.println("============");
	}
	
	@Test
	void deleteTicket() {
		Ticket remove = tr.findById(6).get();
		tr.delete(remove);
	}

}
