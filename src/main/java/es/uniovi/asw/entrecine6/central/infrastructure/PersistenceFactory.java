package es.uniovi.asw.entrecine6.central.infrastructure;

import impl.uniovi.asw.entrecine6.central.business.PaymentServiceImpl;
import impl.uniovi.asw.entrecine6.central.business.UsersServiceImpl;
import impl.uniovi.asw.entrecine6.central.persistence.dao.MovieJdbcDao;
import es.uniovi.asw.entrecine6.central.business.PaymentService;
import es.uniovi.asw.entrecine6.central.business.UsersService;
import es.uniovi.asw.entrecine6.central.persistence.dao.MovieDao;

public class PersistenceFactory {
	
	public static MovieDao getMovieDao() {
		return new MovieJdbcDao();
	}

	public static PaymentService getPaymentService() {
		return new PaymentServiceImpl();
	}

	public static UsersService getUsersService() {
		return new UsersServiceImpl();
	}
}
