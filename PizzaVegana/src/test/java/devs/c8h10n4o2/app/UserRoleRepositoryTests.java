package devs.c8h10n4o2.app;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import devs.c8h10n4o2.entities.UserRole;
import devs.c8h10n4o2.repositories.UserRoleRepository;

@SpringBootTest
@ContextConfiguration(classes = devs.c8h10n4o2.app.PizzaVeganaApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRoleRepositoryTests {

	@Autowired
	UserRoleRepository urr;
	
	@Test
	void createUserRoles() {
		//UserRole ur1 = new UserRole(0,"Employee");
		//urr.save(ur1);
		//UserRole ur2 = new UserRole(0,"Client");
		//urr.save(ur2);
		UserRole ur3 = new UserRole(0,"Manager");
		urr.save(ur3);
	}
	
	@Test
	void getUserRoleById() {
		UserRole ur1 =urr.findById(1).get();
		System.out.println(ur1);
	}

}
