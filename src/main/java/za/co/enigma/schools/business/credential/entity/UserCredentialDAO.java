package za.co.enigma.schools.business.credential.entity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import za.co.enigma.common.jpa.crud.CrudDAOService;

@Stateless
public class UserCredentialDAO extends CrudDAOService<User>{
	
	public UserCredentialDAO() {}
	
	@Inject
	public UserCredentialDAO(EntityManager em) {
		super(em);
	}
}
