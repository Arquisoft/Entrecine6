package impl.uniovi.asw.entrecine6.central.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.Jdbc;
import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.SQLLoader;
import es.uniovi.asw.entrecine6.central.model.Movie;
import es.uniovi.asw.entrecine6.central.persistence.dao.MovieDao;
import es.uniovi.asw.entrecine6.central.persistence.exception.NotPersistedException;
import es.uniovi.asw.entrecine6.central.persistence.exception.PersistenceException;

public class MovieJdbcDao implements MovieDao {

	private Connection connection;

	@Override
	public void setConnection(Connection con) {
		this.connection = con;
	}

	@Override
	public List<Movie> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Movie> movies = new ArrayList<Movie>();
		try {
			pst = connection.prepareStatement(SQLLoader
					.get("SQL_FIND_ALL_MOVIES"));

			rs = pst.executeQuery();

			while (rs.next())
				movies.add(load(rs));

			return movies;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}

	}

	@Override
	public void update(Movie movie) throws NotPersistedException {
		PreparedStatement pst = null;
		try {
			pst = connection
					.prepareStatement(SQLLoader.get("SQL_UPDATE_MOVIE"));

			pst.setBytes(1, movie.getPosterBytes());
			pst.setString(2, movie.getName());
			pst.setString(3, movie.getSinopsis());
			pst.setString(4, movie.getGenre());
			pst.setInt(5, movie.getDuration());
			pst.setLong(6, movie.getId());

			if (pst.executeUpdate() == 0) {
				throw new NotPersistedException();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

	@Override
	public void save(Movie movie) {
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(SQLLoader.get("SQL_SAVE_MOVIE"));

			pst.setBytes(1, movie.getPosterBytes());
			pst.setString(2, movie.getName());
			pst.setString(3, movie.getSinopsis());
			pst.setString(4, movie.getGenre());
			pst.setInt(5, movie.getDuration());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

	@Override
	public Long findLastMovieId() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = connection.prepareStatement(SQLLoader
					.get("SQL_LAST_MOVIE_ID"));

			rs = pst.executeQuery();

			rs.next();

			return rs.getLong(1);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

	@Override
	public String findFavouriteGenre(Long userId) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = connection.prepareStatement(SQLLoader
					.get("SQL_FAVOURITE_MOVIE_GENRE"));
			
			pst.setLong(1, userId);

			rs = pst.executeQuery();

			rs.next();

			return rs.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

	@Override
	public List<Movie> findRecomendations(String genre) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Movie> movies = new ArrayList<Movie>();
		try {
			pst = connection.prepareStatement(SQLLoader
					.get("SQL_FIND_RECOMENDATIONS"));
			
			pst.setString(1, genre);

			rs = pst.executeQuery();

			int counter = 0;
			while (rs.next() && counter < 10) {
				movies.add(load(rs));
			}

			return movies;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

	private Movie load(ResultSet rs) throws SQLException {
		return new Movie(rs.getLong(1), rs.getBytes(2), rs.getString(3),
				rs.getString(4), rs.getString(5), rs.getInt(6), null);
	}

}
