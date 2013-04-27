package impl.uniovi.asw.entrecine6.central.persistence.dao;

import java.sql.Connection;
import java.util.List;

import es.uniovi.asw.entrecine6.central.model.Movie;
import es.uniovi.asw.entrecine6.central.persistence.dao.MovieDao;

public class MovieJdbcDao implements MovieDao {

	private Connection connection;

	@Override
	public void setConnection(Connection con) {
		this.connection = con;
	}

	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
