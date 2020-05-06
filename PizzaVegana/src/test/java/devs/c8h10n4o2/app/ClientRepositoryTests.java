package devs.c8h10n4o2.app;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import devs.c8h10n4o2.entities.Client;
import devs.c8h10n4o2.entities.UserRole;
import devs.c8h10n4o2.repositories.ClientRepository;
import devs.c8h10n4o2.repositories.UserRoleRepository;

@SpringBootTest
@ContextConfiguration(classes = devs.c8h10n4o2.app.PizzaVeganaApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClientRepositoryTests {

	@Autowired
	ClientRepository cr;
	
	@Autowired
	UserRoleRepository urr;
	
	@Test
	void createClient() {
		UserRole ur1 =urr.findById(1).get();
		Client cl = new Client();
		cl.setClientId(0);
		cl.setFirstName("customer2");
		cl.setLastName("customlast");
		cl.setEmail("test@customer2");
		cl.setPhone("111-111-2222");
		cl.setUsername("customer2");
		cl.setPassword("custompass");
		cl.setUserRole(ur1);
		cr.save(cl);
	}
	
	@Test
	void getClientByUsername() {
		Client cl = cr.findByUsername("user3");
		System.out.println(cl);
	}
	
	
	


}
