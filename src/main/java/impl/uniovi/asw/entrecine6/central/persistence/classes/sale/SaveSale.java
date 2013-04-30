package impl.uniovi.asw.entrecine6.central.persistence.classes.sale;

import impl.uniovi.asw.entrecine6.central.persistence.DataEncryptor;
import impl.uniovi.asw.entrecine6.central.persistence.Invoke;

import java.sql.SQLException;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.Jdbc;
import es.uniovi.asw.entrecine6.central.model.Sale;
import es.uniovi.asw.entrecine6.central.persistence.dao.SaleDao;
import es.uniovi.asw.entrecine6.central.persistence.exception.SessionFullException;

public class SaveSale implements Invoke {

	private Sale sale;

	public SaveSale(Sale sale) {
		this.sale = sale;
	}

	@Override
	public Object invoke() throws SQLException, BusinessException {
		DataEncryptor encryptor = new DataEncryptor("AS");
		SaleDao dao = PersistenceFactory.getSaleDao();

		dao.setConnection(Jdbc.getCurrentConnection());

		String encodedInfo = encryptor.encrypt(sale.getPaymentInfo());

		Sale encodedSale = new Sale(sale.getId(), sale.getNumberOfSeats(),
				sale.getSession(), encodedInfo);
		
		dao.saveSale(encodedSale);
		
		encodedSale.setId(dao.findLastSaleId()); 
		
		try {
			dao.saveSeats(encodedSale, sale.getNumberOfSeats());
		} catch (SessionFullException e) {
			throw new BusinessException(e.getMessage());
		}
		
		int[] seats = dao.getSeats(encodedSale);

		return seats;
	}

}