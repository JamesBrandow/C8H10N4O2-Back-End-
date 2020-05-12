package devs.c8h10n4o2.app;

import java.util.List;

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
		//Client cl = new Client(0,"ehi","ehi", ur1);
		//cr.save(cl);
	}
	
	@Test
	void getClientByUsername() {
		Client cl = cr.findByUsername("guest");
		System.out.println(cl);
	}
	
	
	@Test
	void getALlClients() {
		Iterable<Client> clients =cr.findAll();
		List<Client> cl = (List<Client>) cr.findAll();
		//Client cl = cr.findAll().
		System.out.println(cl);
	}

	
	
	//Set<Associate> associateset = new HashSet<Associate>((Collection<? extends Associate>) associates);
	//List<Associate> associate = (List<Associate>) ar.findAll();
	
	//Set<Associate> associateset1 = (HashSet<Associate>) ar.findAll();
	//System.out.println(associateset);

}
