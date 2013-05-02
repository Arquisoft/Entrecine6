package main.java.es.uniovi.asw.ServerBillboard.com.persistence;

import main.java.es.uniovi.asw.ServerBillboard.impl.persistence.MovieDAO;
import main.java.es.uniovi.asw.ServerBillboard.impl.persistence.SessionDAO;



public interface PersistenceFactory {
	
	public MovieDAO createMovieDAO();
	
	public SessionDAO createSessionDAO();

}
