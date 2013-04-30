package impl.uniovi.asw.entrecine6.central.business.users;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.infrastructure.DBServicesFactory;
import es.uniovi.asw.entrecine6.central.model.User;
import es.uniovi.asw.entrecine6.central.persistence.UserDBService;

public class UserLoader {

	public User loadUser(String userName, String password) {
		UserDBService service = DBServicesFactory
				.getUserDBService();
		try {
			return service.loadUser(userName, password);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
