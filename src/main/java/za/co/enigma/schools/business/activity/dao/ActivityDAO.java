package za.co.enigma.schools.business.activity.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import za.co.enigma.common.jpa.crud.CrudDAOService;
import za.co.enigma.schools.business.activity.entity.Activity;

@Stateless
public class ActivityDAO extends CrudDAOService<Activity>{

	public ActivityDAO() {}
	
	@Inject
	public ActivityDAO(EntityManager em) {
		super(em);
	}
}
