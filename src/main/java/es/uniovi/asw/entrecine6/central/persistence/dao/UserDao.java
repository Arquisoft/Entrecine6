package es.uniovi.asw.entrecine6.central.persistence.dao;

import java.sql.Connection;
import java.util.List;

import es.uniovi.asw.entrecine6.central.model.User;

public interface UserDao {
	
	void setConnection(Connection con);

	User findByLogin(String encodedUserName, String encodedPassword);

	void save(User encodedUser);

	List<User> findAll();

}
