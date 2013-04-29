package main.java.es.uniovi.asw.entrecine.administration.es.persisntece;

import java.util.List;

import es.uniovi.asw.entrecine.central.system.model.User;

public interface UserDao {
	List<User> getUsers();

	User findByName (String name);
	User findByLogin (String login);
}
