package impl.uniovi.asw.entrecine6.central.persistence;

import impl.uniovi.asw.entrecine6.central.persistence.classes.user.AddUser;
import impl.uniovi.asw.entrecine6.central.persistence.classes.user.FindByLogin;
import es.uniovi.asw.entrecine6.central.model.User;
import es.uniovi.asw.entrecine6.central.persistence.UserDBService;

public class UserDBServiceImpl implements UserDBService{

	@Override
	public User loadUser(String userName, String password) {
		return (User) new Summoner().invoke(new FindByLogin(userName,password));
	}

	@Override
	public boolean saveUser(User user) {
		return (Boolean) new Summoner().invoke(new AddUser(user));
	}

}
