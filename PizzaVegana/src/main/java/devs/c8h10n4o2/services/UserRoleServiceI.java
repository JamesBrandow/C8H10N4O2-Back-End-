package devs.c8h10n4o2.services;

import java.util.List;

import devs.c8h10n4o2.entities.UserRole;

public interface UserRoleServiceI {
	
	UserRole createUserRole(UserRole userrole);
	UserRole getUserRoleById(int id);
	UserRole getUserRoleByTitle(String title);
	List<UserRole> getAllUserRole();
	UserRole updateUserRole(UserRole userrole);
	boolean deleteUserRole(UserRole userrole);
	
}