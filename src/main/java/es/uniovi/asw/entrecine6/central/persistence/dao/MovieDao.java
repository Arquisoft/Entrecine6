package es.uniovi.asw.entrecine6.central.persistence.dao;

import java.sql.Connection;
import java.util.List;

import es.uniovi.asw.entrecine6.central.model.Movie;
import es.uniovi.asw.entrecine6.central.persistence.exception.NotPersistedException;

public interface MovieDao {
	
	void setConnection(Connection con);

	List<Movie> findAll();

	void updateMovie(Movie movie) throws NotPersistedException;
	
	void saveMovie(Movie movie);
	
	Long findLastMovieId();

}