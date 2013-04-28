package impl.uniovi.asw.entrecine6.central.persistence.classes.user;

import impl.uniovi.asw.entrecine6.central.persistence.DataEncryptor;
import impl.uniovi.asw.entrecine6.central.persistence.Invoke;

import java.sql.SQLException;
import java.util.List;

import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.Jdbc;
import es.uniovi.asw.entrecine6.central.model.Movie;
import es.uniovi.asw.entrecine6.central.model.User;
import es.uniovi.asw.entrecine6.central.persistence.dao.UserDao;

public class FindByLogin implements Invoke {

	private String userName;
	private String password;

	public FindByLogin(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	public User invoke() throws SQLException {
		DataEncryptor encryptor = new DataEncryptor("AS");
		UserDao dao = PersistenceFactory.getUserDao();

		dao.setConnection(Jdbc.getCurrentConnection());

		String encodedUserName = encryptor.encrypt(userName);
		String encodedPassword = encryptor.encrypt(password);

		User encodedUser = dao.findByLogin(encodedUserName, encodedPassword);

		String decodedName = encryptor.decrypt(encodedUser.getName());
		String decodedSurname = encryptor.decrypt(encodedUser.getSurname());
		String decodedEmail = encryptor.decrypt(encodedUser.getEmail());
		String decodedCreditCard = encryptor.decrypt(encodedUser
				.getCreditCard());

		List<Movie> recomendations = null;

		return new User(encodedUser.getId(), decodedName, decodedSurname, userName,
				decodedEmail, password, decodedCreditCard, recomendations);
	}

}
