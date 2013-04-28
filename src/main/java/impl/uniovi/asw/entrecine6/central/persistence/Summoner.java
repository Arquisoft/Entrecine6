package impl.uniovi.asw.entrecine6.central.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.Jdbc;

public class Summoner {

	public Object invoke(Invoke eon) throws BusinessException {

		Connection connection = createConnection();

		try {
			Object obj = eon.invoke();

			connection.commit();

			return obj;

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
			}
			throw new RuntimeException(e);

		} finally {
			Jdbc.close(connection);
		}
	}

	private Connection createConnection() {
		try {
			return Jdbc.createThreadConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
