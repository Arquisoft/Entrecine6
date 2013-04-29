package main.java.es.uniovi.asw.entrecine.administration.es.business;

import java.util.List;

import es.uniovi.asw.entrecine.central.system.model.User;

public interface UserService {
	List<User> getUsers();
	User findById (Long id);
	User findByName (String name);
	User findByLogin (String login);
}
