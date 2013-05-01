package impl.uniovi.asw.entrecine6.central.persistence;

import impl.uniovi.asw.entrecine6.central.persistence.classes.user.AddUser;
import impl.uniovi.asw.entrecine6.central.persistence.classes.user.FindAllUsers;
import impl.uniovi.asw.entrecine6.central.persistence.classes.user.Login;

import java.util.List;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.model.User;
import es.uniovi.asw.entrecine6.central.persistence.UserDBService;

public class UserDBServiceImpl implements UserDBService{

	@Override
	public User loadUser(String userName, String password) throws BusinessException {
		return (User) new Summoner().invoke(new Login(userName,password));
	}

	@Override
	public boolean saveUser(User user) throws BusinessException {
		return (Boolean) new Summoner().invoke(new AddUser(user));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() throws BusinessException {
		return (List<User>) new Summoner().invoke(new FindAllUsers());
	}

}
