package es.uniovi.asw.entrecine6.central.infrastructure;

import impl.uniovi.asw.entrecine6.central.persistence.dao.MovieJdbcDao;
import impl.uniovi.asw.entrecine6.central.persistence.dao.SaleJdbcDao;
import impl.uniovi.asw.entrecine6.central.persistence.dao.SessionJdbcDao;
import impl.uniovi.asw.entrecine6.central.persistence.dao.UserJdbcDao;
import es.uniovi.asw.entrecine6.central.persistence.dao.MovieDao;
import es.uniovi.asw.entrecine6.central.persistence.dao.SaleDao;
import es.uniovi.asw.entrecine6.central.persistence.dao.SessionDao;
import es.uniovi.asw.entrecine6.central.persistence.dao.UserDao;

public class PersistenceFactory {
	
	public static MovieDao getMovieDao() {
		return new MovieJdbcDao();
	}

	public static SaleDao getSaleDao() {
		return new SaleJdbcDao();
	}

	public static UserDao getUserDao() {
		return new UserJdbcDao();
	}
	
	public static SessionDao getSesionDao() {
		return new SessionJdbcDao();
	}
}
