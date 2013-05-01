package es.uniovi.asw.entrecine6.central.persistence.dao;

import java.sql.Connection;
import java.util.List;

import es.uniovi.asw.entrecine6.central.model.Movie;
import es.uniovi.asw.entrecine6.central.persistence.exception.NotPersistedException;

public interface MovieDao {
	
	void setConnection(Connection con);

	List<Movie> findAll();

	void update(Movie movie) throws NotPersistedException;
	
	void save(Movie movie);
	
	Long findLastMovieId();

	String findFavouriteGenre(Long userId);

	List<Movie> findRecomendations(String genre);

}
