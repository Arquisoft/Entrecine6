package impl.uniovi.asw.entrecine6.central.business.users;

import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.model.User;
import es.uniovi.asw.entrecine6.central.persistence.UserPersistenceService;

public class UserLoader {

	public User loadUser(String userName, String password) {
		UserPersistenceService service = PersistenceFactory
				.getUserPersistenceService();
		return service.loadUser(userName, password);
	}

}
