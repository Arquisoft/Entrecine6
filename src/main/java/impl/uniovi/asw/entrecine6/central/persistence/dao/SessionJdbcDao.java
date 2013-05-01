package impl.uniovi.asw.entrecine6.central.persistence.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.Jdbc;
import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.SQLLoader;
import es.uniovi.asw.entrecine6.central.model.Session;
import es.uniovi.asw.entrecine6.central.persistence.dao.SessionDao;
import es.uniovi.asw.entrecine6.central.persistence.exception.NotPersistedException;
import es.uniovi.asw.entrecine6.central.persistence.exception.PersistenceException;

public class SessionJdbcDao implements SessionDao {

	private Connection connection;

	@Override
	public void setConnection(Connection con) {
		this.connection = con;
	}

	@Override
	public List<Session> findByMovie(Long idMovie) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Session> sessions = new ArrayList<Session>();
		try {
			pst = connection.prepareStatement(SQLLoader
					.get("SQL_FIND_SESSIONS_BY_MOVIE"));

			pst.setLong(1, idMovie);

			rs = pst.executeQuery();

			while (rs.next())
				sessions.add(load(rs));

			return sessions;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

	@Override
	public void update(Session session) throws NotPersistedException {
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(SQLLoader
					.get("SQL_UPDATE_SESSION"));

			pst.setInt(1, session.getTheater());
			pst.setDate(2, (Date) session.getDate());
			pst.setFloat(3, session.getStartTime());
			pst.setFloat(4, session.getPrize());
			pst.setLong(5, session.getIdMovie());

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
	public void save(Session session) {
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(SQLLoader
					.get("SQL_SAVE_SESSION"));

			pst.setLong(1, session.getIdMovie());
			pst.setInt(2, session.getTheater());
			pst.setDate(3, (Date) session.getDate());
			pst.setFloat(4, session.getStartTime());
			pst.setFloat(5, session.getPrize());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

	private Session load(ResultSet rs) throws SQLException {
		return new Session(rs.getLong(1), rs.getLong(2), rs.getInt(3),
				rs.getDate(4), rs.getFloat(5), rs.getFloat(6));
	}

}
