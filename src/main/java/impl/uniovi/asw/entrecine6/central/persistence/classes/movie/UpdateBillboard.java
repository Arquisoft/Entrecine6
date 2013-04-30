package impl.uniovi.asw.entrecine6.central.persistence.classes.movie;

import impl.uniovi.asw.entrecine6.central.persistence.Invoke;

import java.sql.SQLException;
import java.util.List;

import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.Jdbc;
import es.uniovi.asw.entrecine6.central.model.Movie;
import es.uniovi.asw.entrecine6.central.persistence.dao.MovieDao;

public class UpdateBillboard implements Invoke {
	
	private List<Movie> billboard;

	public UpdateBillboard(List<Movie>  billboard) {
		this.billboard = billboard;
	}

	@Override
	public Object invoke() throws SQLException {
		MovieDao dao = PersistenceFactory.getMovieDao();

		dao.setConnection(Jdbc.getCurrentConnection());

		dao.updateBillboard(billboard);

		return null;
	}

}
