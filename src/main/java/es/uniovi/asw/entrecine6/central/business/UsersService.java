package es.uniovi.asw.entrecine6.central.business;

import es.uniovi.asw.entrecine6.central.model.User;

public interface UsersService {
	
	User loadUser(String userName, String password);
	
	boolean saveUser(User user);

}