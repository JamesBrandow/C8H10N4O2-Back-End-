package devs.c8h10n4o2.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import devs.c8h10n4o2.entities.Pizza;
import devs.c8h10n4o2.entities.Ticket;
import devs.c8h10n4o2.repositories.PizzaRepository;
import devs.c8h10n4o2.repositories.TicketRepository;

@SpringBootTest
@ContextConfiguration(classes = devs.c8h10n4o2.app.PizzaVeganaApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PizzaServiceTest {

	@Autowired
	TicketRepository tr;
	
	@Autowired
	PizzaRepository pr;
	
	
	//@Test
	void createPizza() {		
		Pizza p = new Pizza(0,7,"Test new Pizza");
		p.setStatus("Testing");
		pr.save(p);
		System.out.println(p);
	}

	//@Test
	void findById() {
		Pizza p = pr.findByPizzaId(1);
		System.out.println(p);
	}
	
	//@Test
	void findByName() {
		Pizza p = pr.findByPizzaName("Test Pizza");
		System.out.println(p);
	}
	
	
}
