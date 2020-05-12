package devs.c8h10n4o2.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import devs.c8h10n4o2.entities.Ticket;
import devs.c8h10n4o2.repositories.ClientRepository;
import devs.c8h10n4o2.repositories.PizzaRepository;
import devs.c8h10n4o2.repositories.TicketRepository;
import devs.c8h10n4o2.repositories.UserRoleRepository;

@SpringBootTest
@ContextConfiguration(classes = devs.c8h10n4o2.app.PizzaVeganaApplication.class)
public class TicketRepositoryTests {
	
	@Autowired
	UserRoleRepository ur;
	
	@Autowired
	TicketRepository tr;
	
	@Autowired
	ClientRepository cr;
	
	@Autowired
	PizzaRepository pr;
	
	@Test
	void createTicketTest() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));  
		
		
		Ticket t1 = new Ticket();
		t1.setPlacementTime(dtf.format(now));
		t1.setStatus("preparing");
		t1.setNote("test from Java");
		t1.setClient(cr.findById(1).get());
		t1.setCost(10);
		tr.save(t1);
		System.out.println("============");
		System.out.println(t1);
		System.out.println("============");
	}
	
	@Test
	void getAllTickets() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		String dtfString = dtf.format(now);
		System.out.println("DateTime = "+dtfString);
		System.out.println("Date = "+dtfString.substring(0, 10));
		System.out.println("Time = "+dtfString.substring(11));
		
		
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
