package es.uniovi.asw.entrecine6.central.persistence;

import java.util.List;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.model.User;

public interface UserDBService {

	User loadUser(String userName, String password) throws BusinessException;

	boolean saveUser(User user) throws BusinessException;

	List<User> findAll() throws BusinessException;

}
