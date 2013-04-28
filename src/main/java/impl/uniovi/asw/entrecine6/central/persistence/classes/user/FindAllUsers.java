package impl.uniovi.asw.entrecine6.central.persistence.classes.user;

import impl.uniovi.asw.entrecine6.central.persistence.DataEncryptor;
import impl.uniovi.asw.entrecine6.central.persistence.Invoke;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.Jdbc;
import es.uniovi.asw.entrecine6.central.model.User;
import es.uniovi.asw.entrecine6.central.persistence.dao.UserDao;

public class FindAllUsers implements Invoke {

	@Override
	public List<User> invoke() throws SQLException {
		DataEncryptor encryptor = new DataEncryptor("AS");
		UserDao dao = PersistenceFactory.getUserDao();

		dao.setConnection(Jdbc.getCurrentConnection());

		List<User> users = dao.findAll();

		List<User> decodedUsers = new ArrayList<User>();

		for (User user : users) {

			String decodedUserName = encryptor.decrypt(user.getUserName());
			String decodedPassword = encryptor.decrypt(user.getPassword());
			String decodedName = encryptor.decrypt(user.getName());
			String decodedSurname = encryptor.decrypt(user.getSurname());
			String decodedEmail = encryptor.decrypt(user.getEmail());
			String decodedCreditCard = encryptor.decrypt(user.getCreditCard());

			User decodedUser = new User(user.getId(), decodedName,
					decodedSurname, decodedUserName, decodedEmail,
					decodedPassword, decodedCreditCard, null);

			decodedUsers.add(decodedUser);
		}

		return decodedUsers;
	}

}
