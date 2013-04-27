package es.uniovi.asw.entrecine6.central.persistence.dao;

import java.sql.Connection;
import java.util.List;

import es.uniovi.asw.entrecine6.central.model.Movie;

public interface MovieDao {
	
	void setConnection(Connection con);

	List<Movie> findAll();

}
