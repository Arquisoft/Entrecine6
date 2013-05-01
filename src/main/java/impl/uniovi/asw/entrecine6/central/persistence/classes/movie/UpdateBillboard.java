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
import es.uniovi.asw.entrecine6.central.persistence.exception.NotPersistedException;

public class UpdateBillboard implements Invoke {

	private List<Movie> billboard;

	public UpdateBillboard(List<Movie> billboard) {
		this.billboard = billboard;
	}

	@Override
	public Object invoke() throws SQLException {
		MovieDao movieDao = PersistenceFactory.getMovieDao();
		SessionDao sessionDao = PersistenceFactory.getSessionDao();

		Connection con = Jdbc.getCurrentConnection();

		movieDao.setConnection(con);
		sessionDao.setConnection(con);

		for (Movie movie : billboard) {
			if (movie.getId() != null) {
				try {
					movieDao.update(movie);
				} catch (NotPersistedException e) {
					e.printStackTrace();
					movieDao.save(movie);
					Long idMovie = movieDao.findLastMovieId();
					movie.setId(idMovie);
				}
			}else{
				movieDao.save(movie);
				Long idMovie = movieDao.findLastMovieId();
				movie.setId(idMovie);
			}
			List<Session> sessions = movie.getSessions();
			for (Session session : sessions) {
				session.setIdMovie(movie.getId());
				if (session.getId() != null) {
					try {
						sessionDao.update(session);
					} catch (NotPersistedException e) {
						e.printStackTrace();
						sessionDao.save(session);
					}
				} else {
					sessionDao.save(session);
				}
			}
		}

		return null;
	}

}
