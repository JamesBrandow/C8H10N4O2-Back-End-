package devs.c8h10n4o2.app;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import devs.c8h10n4o2.entities.PizzaItems;
import devs.c8h10n4o2.repositories.PizzaItemRepository;

@SpringBootTest
@ContextConfiguration(classes = devs.c8h10n4o2.app.PizzaVeganaApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PizzaItemServiceTest {
	
	@Autowired
	PizzaItemRepository pir;

	@Test
	void getAll() {
		List<PizzaItems> pi = (List<PizzaItems>) pir.findAll();
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
