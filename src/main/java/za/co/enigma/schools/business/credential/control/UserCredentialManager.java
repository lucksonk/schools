package za.co.enigma.schools.business.credential.control;

import javax.ejb.Stateless;
import javax.inject.Inject;

import za.co.enigma.schools.business.credential.entity.User;
import za.co.enigma.schools.business.credential.entity.UserCredentialDAO;



@Stateless
public class UserCredentialManager {

	private UserCredentialDAO userCredentialDao;
	
	public UserCredentialManager() {}
	
	@Inject
	public UserCredentialManager(UserCredentialDAO userCredentialDao) {
		this.userCredentialDao = userCredentialDao;
	}
	
	public User create(User user) {
		User createdUser = userCredentialDao.create(user);
		return createdUser;
	}
	
	
}
