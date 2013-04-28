package impl.uniovi.asw.entrecine6.central.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.Jdbc;
import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.SQLLoader;
import es.uniovi.asw.entrecine6.central.model.Sale;
import es.uniovi.asw.entrecine6.central.model.Ticket;
import es.uniovi.asw.entrecine6.central.persistence.dao.SaleDao;
import es.uniovi.asw.entrecine6.central.persistence.exception.DuplicatedTicketException;
import es.uniovi.asw.entrecine6.central.persistence.exception.PersistenceException;

public class SaleJdbcDao implements SaleDao {

	private Connection connection;

	@Override
	public void setConnection(Connection con) {
		this.connection = con;
	}

	@Override
	public void saveTicket(Ticket ticket) throws SQLException,
			DuplicatedTicketException {
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(SQLLoader.get("SQL_SAVE_TICKET"));

			pst.setString(1, ticket.getCode());

			pst.setLong(2, ticket.getInfo().getId());

			pst.executeUpdate();

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw new DuplicatedTicketException(ticket.getCode()
					+ " is duplicated");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}

	}

	@Override
	public Ticket findTicketByCode(String ticketCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSale(Sale sale) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Sale> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
