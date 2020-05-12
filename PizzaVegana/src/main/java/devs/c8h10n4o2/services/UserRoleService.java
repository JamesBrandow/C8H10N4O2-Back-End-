package devs.c8h10n4o2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import devs.c8h10n4o2.entities.UserRole;
import devs.c8h10n4o2.repositories.UserRoleRepository;

@Component
@Service
public class UserRoleService implements UserRoleServiceI {
	
	@Autowired
	UserRoleRepository urr;

	@Override
	public UserRole createUserRole(UserRole userrole) {
		userrole = urr.save(userrole);
		return userrole;
	}

	@Override
	public UserRole getUserRoleById(int id) {
		
		return urr.findById(id).get();
	}

	@Override
	public UserRole getUserRoleByTitle(String title) {
		return urr.findByTitle(title);
	}

	@Override
	public List<UserRole> getAllUserRole() {
		List<UserRole> userroles = (List<UserRole>) urr.findAll();
		return userroles;
	}

	@Override
	public UserRole updateUserRole(UserRole userrole) {
		userrole = urr.save(userrole);
		return userrole;
	}

	@Override
	public boolean deleteUserRole(UserRole userrole) {
		try {
			urr.delete(userrole);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}