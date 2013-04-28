package impl.uniovi.asw.entrecine6.central.persistence.classes.user;

import java.sql.SQLException;

import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.Jdbc;
import es.uniovi.asw.entrecine6.central.model.User;
import es.uniovi.asw.entrecine6.central.persistence.dao.UserDao;

import impl.uniovi.asw.entrecine6.central.persistence.DataEncryptor;
import impl.uniovi.asw.entrecine6.central.persistence.Invoke;

public class AddUser implements Invoke {

	private User user;

	public AddUser(User user) {
		this.user = user;
	}

	@Override
	public Object invoke() throws SQLException {
		DataEncryptor encryptor = new DataEncryptor("AS");
		UserDao dao = PersistenceFactory.getUserDao();

		dao.setConnection(Jdbc.getCurrentConnection());

		String encodedUserName = encryptor.encrypt(user.getUserName());
		String encodedPassword = encryptor.encrypt(user.getPassword());
		String encodedName = encryptor.encrypt(user.getName());
		String encodedSurname = encryptor.encrypt(user.getSurname());
		String encodedEmail = encryptor.encrypt(user.getEmail());
		String encodedCreditCard = encryptor.encrypt(user.getCreditCard());

		User encodedUser = new User(null, encodedName, encodedSurname,
				encodedUserName, encodedEmail, encodedPassword,
				encodedCreditCard, null);
		
		dao.save(encodedUser);
		
		return null;
	}

}
