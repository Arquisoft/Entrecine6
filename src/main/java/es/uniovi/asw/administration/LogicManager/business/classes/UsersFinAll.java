package main.java.es.uniovi.asw.entrecine.administration.LogicManager.business.classes;

import java.util.List;

import es.uniovi.asw.entrecine.central.system.model.User;
import main.java.es.uniovi.asw.entrecine.administration.es.infraestructure.Factories;
import main.java.es.uniovi.asw.entrecine.administration.es.persisntece.UserDao;


public class UsersFinAll {

	public List<User> users() {
		UserDao dao = Factories.persistence.creaUserDao();
		return dao.getUsers();
		
	}

}
