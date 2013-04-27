package impl.uniovi.asw.entrecine6.central.business.users;

import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.model.User;
import es.uniovi.asw.entrecine6.central.persistence.UserPersistenceService;

public class UserSaver {

	// Tiene que cazar la excepcion
	public boolean saveUser(User user) {
		UserPersistenceService service = PersistenceFactory.getUserPersistenceService();
		return service.saveUser(user);
	}

}
