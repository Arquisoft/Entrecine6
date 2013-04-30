package impl.uniovi.asw.entrecine6.central.business.users;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.infrastructure.DBServicesFactory;
import es.uniovi.asw.entrecine6.central.model.User;
import es.uniovi.asw.entrecine6.central.persistence.UserDBService;

public class UserSaver {

	// Tiene que cazar la excepcion
	public boolean saveUser(User user) {
		UserDBService service = DBServicesFactory.getUserDBService();
		try {
			return service.saveUser(user);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return false;
	}

}
