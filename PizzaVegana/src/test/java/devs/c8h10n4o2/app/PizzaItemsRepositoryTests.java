package devs.c8h10n4o2.app;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import devs.c8h10n4o2.entities.PizzaItems;
import devs.c8h10n4o2.repositories.ClientRepository;
import devs.c8h10n4o2.repositories.PizzaItemRepository;
import devs.c8h10n4o2.repositories.PizzaRepository;
import devs.c8h10n4o2.repositories.TicketRepository;

@SpringBootTest
@ContextConfiguration(classes = devs.c8h10n4o2.app.PizzaVeganaApplication.class)
class PizzaItemRepositoryTests {

	@Autowired
	PizzaRepository pr;
	
	@Autowired
	TicketRepository tr;
	
	@Autowired
	ClientRepository cr;
	
	@Autowired
	PizzaItemRepository pir;
	
	
	
	@Test
	void getAllPizzaItemsTest() {

		List<PizzaItems> pizzaitems = (List<PizzaItems>) pir.findAll();
		for(PizzaItems pi : pizzaitems) {
			System.out.println(pi);
		}
	}
	
	@Test
	void getPizzaItemsByIdTest() {
		PizzaItems pi = pir.findById(1).get();
		System.out.println(pi);
	}
	//@Test
	void getByCategory() {
		List<PizzaItems> pi = (List<PizzaItems>) pir.findByCategory("sauce");
		System.out.println(pi);
	}
	

	//@Test
	void getByName() {
		PizzaItems pi = pir.findByItemName("Hand Tossed").get(0);
		System.out.println(pi);
	}
	
	//@Test
	void getById() {
		PizzaItems pi = pir.findByItemId(5);
		System.out.println(pi);
	}
}
