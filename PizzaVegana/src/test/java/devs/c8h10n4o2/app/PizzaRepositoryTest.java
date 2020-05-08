package devs.c8h10n4o2.app;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import devs.c8h10n4o2.entities.Pizza;
import devs.c8h10n4o2.repositories.ClientRepository;
import devs.c8h10n4o2.repositories.PizzaRepository;
import devs.c8h10n4o2.repositories.TicketRepository;

@SpringBootTest
@ContextConfiguration(classes = devs.c8h10n4o2.app.PizzaVeganaApplication.class)
class PizzaRepositoryTests {
	
	@Autowired
	PizzaRepository pr;
	
	@Autowired
	TicketRepository tr;
	
	@Autowired
	ClientRepository cr;
	
	@Test
	void createPizzaTest() {
		Pizza p1 = new Pizza();
		p1.setTicket(tr.findById(1).get());
		p1.setPrice(10);
		p1.setPizzaName("Stuffed Crust Veggie Pizza");
		p1.setStatus("Preparing");
		pr.save(p1);
		System.out.println(p1);
	}
	
	@Test
	void getAllPizzaTest() {
		List<Pizza> pizzas = (List<Pizza>) pr.findAll();
		for(Pizza p : pizzas) {
			System.out.println(p);
		}
	}
	
	@Test
	void getPizzaByIdTest() {
		Pizza p = pr.findById(1).get();
		System.out.println(p);
	}
	
	@Test
	void deletePizzaTest() {
		Pizza toBeDeleted = pr.findById(2).get();
		pr.delete(toBeDeleted);
	}	
}

