package es.uniovi.asw.entrecine6.central.persistence;

import es.uniovi.asw.entrecine6.central.model.User;

public interface UserPersistenceService {
	
	User loadUser(String userName, String password);

	boolean saveUser(User user);

}