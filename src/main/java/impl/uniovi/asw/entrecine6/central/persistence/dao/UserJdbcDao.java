package impl.uniovi.asw.entrecine6.central.persistence.dao;

import java.sql.Connection;
import java.util.List;

import es.uniovi.asw.entrecine6.central.model.User;
import es.uniovi.asw.entrecine6.central.persistence.dao.UserDao;

public class UserJdbcDao implements UserDao {

	private Connection connection;

	@Override
	public void setConnection(Connection con) {
		this.connection = con;
	}

	@Override
	public User findByLogin(String encodedUserName, String encodedPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User encodedUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
