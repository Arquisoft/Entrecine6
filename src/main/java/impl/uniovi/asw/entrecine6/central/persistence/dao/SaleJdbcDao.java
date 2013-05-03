package impl.uniovi.asw.entrecine6.central.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.Jdbc;
import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.SQLLoader;
import es.uniovi.asw.entrecine6.central.model.Sale;
import es.uniovi.asw.entrecine6.central.model.Session;
import es.uniovi.asw.entrecine6.central.model.Ticket;
import es.uniovi.asw.entrecine6.central.persistence.dao.SaleDao;
import es.uniovi.asw.entrecine6.central.persistence.exception.DuplicatedTicketException;
import es.uniovi.asw.entrecine6.central.persistence.exception.OccupiedSeatException;
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
	public Sale findSaleByTicket(String ticketCode) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = connection.prepareStatement(SQLLoader
					.get("SQL_FIND_SALE_BY_TICKET"));

			pst.setString(1, ticketCode);

			rs = pst.executeQuery();

			rs.next();

			return load(rs);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

	@Override
	public void saveSale(Sale sale) {
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(SQLLoader.get("SQL_SAVE_SALE"));

			pst.setString(1, sale.getPaymentInfo());

			pst.setLong(2, sale.getSession().getId());

			pst.setFloat(3,
					sale.getSession().getPrize() * sale.getNumberOfSeats());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

	@Override
	public List<Sale> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Sale> sales = new ArrayList<Sale>();
		try {
			pst = connection.prepareStatement(SQLLoader
					.get("SQL_FIND_ALL_SALES"));

			rs = pst.executeQuery();

			while (rs.next())
				sales.add(load(rs));

			return sales;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

	@Override
	public Long findLastSaleId() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = connection
					.prepareStatement(SQLLoader.get("SQL_LAST_SALE_ID"));

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
	public int findLastSeat(Sale sale) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = connection.prepareStatement(SQLLoader.get("SQL_LAST_SEAT"));

			pst.setLong(1, sale.getId());
			pst.setLong(2, sale.getSession().getId());

			rs = pst.executeQuery();

			rs.next();

			return rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

	@Override
	public void saveSeat(Sale sale, int seat) throws OccupiedSeatException {
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(SQLLoader.get("SQL_SAVE_SEAT"));

			pst.setLong(1, sale.getId());
			pst.setLong(2, sale.getSession().getId());
			pst.setInt(3, seat);

			pst.executeUpdate();

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw new OccupiedSeatException("Seat nº " + seat + " is ocuped");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

	private Sale load(ResultSet rs) throws SQLException {
		Session session = new Session(rs.getLong(2), rs.getLong(3),
				rs.getInt(4), rs.getDate(5), rs.getFloat(6), rs.getFloat(7));
		float totalPrize = rs.getFloat(9);
		return new Sale(rs.getLong(1), (int) (totalPrize / session.getPrize()),
				session, rs.getString(8));
	}
}
