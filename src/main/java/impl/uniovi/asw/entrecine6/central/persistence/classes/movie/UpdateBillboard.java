package impl.uniovi.asw.entrecine6.central.persistence.classes.movie;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.Jdbc;
import es.uniovi.asw.entrecine6.central.persistence.dao.MovieDao;

import impl.uniovi.asw.entrecine6.central.persistence.Invoke;

public class UpdateBillboard implements Invoke {
	
	private CachedRowSet billboard;

	public UpdateBillboard(CachedRowSet billboard) {
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
