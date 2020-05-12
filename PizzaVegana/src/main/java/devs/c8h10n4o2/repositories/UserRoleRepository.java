package devs.c8h10n4o2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import devs.c8h10n4o2.entities.UserRole;

@Component
@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {
	
	UserRole findByTitle(String title);
	//UserRole findById(int id);
	//UserRole getUserRoleById(int i);


}