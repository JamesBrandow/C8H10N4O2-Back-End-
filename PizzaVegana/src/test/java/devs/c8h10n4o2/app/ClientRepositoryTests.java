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
		UserRole ur1 =urr.findById(2).get();
		Client cl = new Client();
		cl.setClientId(0);
		cl.setFirstName("test");
		cl.setLastName("testlast2");
		cl.setEmail("test@test2");
		cl.setPhone("999-999-7777");
		cl.setUsername("user3");
		cl.setPassword("pass3");
		cl.setUserRole(ur1);
		cr.save(cl);
	}
	
	@Test
	void getClientByUsername() {
		Client cl = cr.findByUsername("user3");
		System.out.println(cl);
	}
	
	
	


}
