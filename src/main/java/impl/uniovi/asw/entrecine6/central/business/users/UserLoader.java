package impl.uniovi.asw.entrecine6.central.business.users;

import es.uniovi.asw.entrecine6.central.infrastructure.DBServicesFactory;
import es.uniovi.asw.entrecine6.central.model.User;
import es.uniovi.asw.entrecine6.central.persistence.UserDBService;

public class UserLoader {

	public User loadUser(String userName, String password) {
		UserDBService service = DBServicesFactory
				.getUserPersistenceService();
		return service.loadUser(userName, password);
	}

}
