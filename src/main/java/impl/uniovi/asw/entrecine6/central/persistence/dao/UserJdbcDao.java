package impl.uniovi.asw.entrecine6.central.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.Jdbc;
import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.SQLLoader;
import es.uniovi.asw.entrecine6.central.model.User;
import es.uniovi.asw.entrecine6.central.persistence.dao.UserDao;
import es.uniovi.asw.entrecine6.central.persistence.exception.PersistenceException;

public class UserJdbcDao implements UserDao {

	private Connection connection;

	@Override
	public void setConnection(Connection con) {
		this.connection = con;
	}

	@Override
	public User findByLogin(String encodedUserName, String encodedPassword) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = connection.prepareStatement(SQLLoader.get("SQL_LOGIN_USER"));

			pst.setString(1, encodedUserName);
			pst.setString(2, encodedPassword);

			rs = pst.executeQuery();

			rs.next();

			return load(rs);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

	@Override
	public void save(User encodedUser) {
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(SQLLoader.get("SQL_SAVE_USER"));

			pst.setString(1, encodedUser.getName());
			pst.setString(2, encodedUser.getSurname());
			pst.setString(3, encodedUser.getUserName());
			pst.setString(4, encodedUser.getEmail());
			pst.setString(5, encodedUser.getPassword());
			pst.setString(6, encodedUser.getCreditCard());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

	@Override
	public List<User> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		try {
			pst = connection.prepareStatement(SQLLoader
					.get("SQL_FIND_ALL_USERS"));

			rs = pst.executeQuery();

			while (rs.next())
				users.add(load(rs));

			return users;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

	private User load(ResultSet rs) throws SQLException {
		return new User(rs.getLong(1), rs.getString(2), rs.getString(3),
				rs.getString(4), rs.getString(5), rs.getString(6),
				rs.getString(7), null);
	}

}
