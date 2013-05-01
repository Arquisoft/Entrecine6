package impl.uniovi.asw.entrecine6.central.persistence.classes.user;

import impl.uniovi.asw.entrecine6.central.persistence.DataEncryptor;
import impl.uniovi.asw.entrecine6.central.persistence.Invoke;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.Jdbc;
import es.uniovi.asw.entrecine6.central.model.Movie;
import es.uniovi.asw.entrecine6.central.model.Session;
import es.uniovi.asw.entrecine6.central.model.User;
import es.uniovi.asw.entrecine6.central.persistence.dao.MovieDao;
import es.uniovi.asw.entrecine6.central.persistence.dao.SessionDao;
import es.uniovi.asw.entrecine6.central.persistence.dao.UserDao;

public class Login implements Invoke {

	private String userName;
	private String password;

	public Login(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	public User invoke() throws SQLException {
		DataEncryptor encryptor = new DataEncryptor("AS");
		UserDao userDao = PersistenceFactory.getUserDao();
		MovieDao movieDao = PersistenceFactory.getMovieDao();
		SessionDao sessionDao = PersistenceFactory.getSessionDao();
		
		Connection con = Jdbc.getCurrentConnection();

		userDao.setConnection(con);
		movieDao.setConnection(con);

		String encodedUserName = encryptor.encrypt(userName);
		String encodedPassword = encryptor.encrypt(password);

		User encodedUser = userDao.findByLogin(encodedUserName, encodedPassword);

		String decodedName = encryptor.decrypt(encodedUser.getName());
		String decodedSurname = encryptor.decrypt(encodedUser.getSurname());
		String decodedEmail = encryptor.decrypt(encodedUser.getEmail());
		String decodedCreditCard = encryptor.decrypt(encodedUser
				.getCreditCard());
		
		String genre = movieDao.findFavouriteGenre(encodedUser.getId());

		List<Movie> recomendations = movieDao.findRecomendations(genre);
		
		for(Movie movie: recomendations){
			List<Session> sessions = sessionDao.findByMovie(movie.getId());
			movie.setSessions(sessions);
		}

		return new User(encodedUser.getId(), decodedName, decodedSurname, userName,
				decodedEmail, password, decodedCreditCard, recomendations);
	}

}
