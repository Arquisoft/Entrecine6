package impl.uniovi.asw.entrecine6.central.business;

import impl.uniovi.asw.entrecine6.central.business.users.UserLoader;
import impl.uniovi.asw.entrecine6.central.business.users.UserSaver;
import es.uniovi.asw.entrecine6.central.business.UsersService;
import es.uniovi.asw.entrecine6.central.model.User;

public class UsersServiceImpl implements UsersService {

	@Override
	public User loadUser(String userName, String password) {
		return new UserLoader().loadUser(userName, password);
	}

	@Override
	public boolean saveUser(User user) {
		return new UserSaver().saveUser(user);
	}

}
