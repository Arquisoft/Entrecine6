package main.java.es.uniovi.asw.ServerBillboard.impl.persistence.Impl;

import main.java.es.uniovi.asw.ServerBillboard.com.persistence.PersistenceFactory;
import main.java.es.uniovi.asw.ServerBillboard.impl.persistence.MovieDAO;
import main.java.es.uniovi.asw.ServerBillboard.impl.persistence.SessionDAO;

public class SimplePersistenceFactory implements PersistenceFactory{

	@Override
	public MovieDAO createMovieDAO() {
		return new MovieJdbcDAO();
	}

	@Override
	public SessionDAO createSessionDAO() {
		return new SessionJdbcDAO();
	}
	
	

	
	
}
