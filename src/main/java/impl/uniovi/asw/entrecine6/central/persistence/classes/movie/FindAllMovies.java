package impl.uniovi.asw.entrecine6.central.persistence.classes.movie;

import impl.uniovi.asw.entrecine6.central.persistence.Invoke;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.Jdbc;
import es.uniovi.asw.entrecine6.central.model.Movie;
import es.uniovi.asw.entrecine6.central.model.Session;
import es.uniovi.asw.entrecine6.central.persistence.dao.MovieDao;
import es.uniovi.asw.entrecine6.central.persistence.dao.SessionDao;

public class FindAllMovies implements Invoke{

	@Override
	public List<Movie> invoke() throws SQLException {
		MovieDao movieDao = PersistenceFactory.getMovieDao();
		SessionDao sessionDao = PersistenceFactory.getSessionDao();
		
		Connection con = Jdbc.getCurrentConnection();
		
		movieDao.setConnection(con);
		sessionDao.setConnection(con);
		
		List<Movie> movies = movieDao.findAll();
		
		for(Movie movie: movies){
			List<Session> sessions = sessionDao.findByMovie(movie.getId());
			movie.setSessions(sessions);
		}
		
		return movies;
	}

}
