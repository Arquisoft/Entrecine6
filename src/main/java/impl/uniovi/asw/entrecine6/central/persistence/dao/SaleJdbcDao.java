package impl.uniovi.asw.entrecine6.central.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import es.uniovi.asw.entrecine6.central.persistence.exception.SessionFullException;

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
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = connection.prepareStatement(SQLLoader.get("SQL_FIND_TICKET_BY_CODE"));

			pst.setString(1, ticketCode);

			rs = pst.executeQuery();
			
			rs.next();
			
			return loadTicket(rs);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

	private Ticket loadTicket(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSale(Sale sale) {
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(SQLLoader.get("SQL_SAVE_SALE"));

			pst.setString(1, sale.getPaymentInfo());

			pst.setLong(2, sale.getSession().getId());

			pst.setFloat(3, sale.getSession().getPrize());

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getLastSaleId() {
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
	public void saveSeats(Sale sale, int numberOfSeats) throws SessionFullException {
		PreparedStatement pst = null;
		try {
			pst = connection
					.prepareStatement(SQLLoader.get("SQL_SAVE_SEAT"));

			pst.setLong(1, sale.getId());
			pst.setLong(2, sale.getSession().getId());
			
			for(int i = 0; i < numberOfSeats; i++){				
				pst.executeUpdate();
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw new SessionFullException(sale.getSession() + " is full");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

	@Override
	public int[] getSeats(Sale sale) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = connection
					.prepareStatement(SQLLoader.get("SQL_GET_SEATS"));
			
			pst.setLong(1, sale.getId());
			pst.setLong(2, sale.getSession().getId());

			rs = pst.executeQuery();
			
			int[] seats = new int[1];

			while(rs.next()){
				int[] temp = new int[seats.length + 1];
				
				int seat = rs.getInt(1);
				
				for(int i = 0; i < seats.length; i++){
					temp[i] = seats[i];
				}
				
				temp[seats.length] = seat;
				
				seats = temp;
			}

			return seats;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			Jdbc.close(pst);
		}
	}

}
