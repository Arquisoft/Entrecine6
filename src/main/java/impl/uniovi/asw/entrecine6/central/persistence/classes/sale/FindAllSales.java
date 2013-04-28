package impl.uniovi.asw.entrecine6.central.persistence.classes.sale;

import impl.uniovi.asw.entrecine6.central.persistence.DataEncryptor;
import impl.uniovi.asw.entrecine6.central.persistence.Invoke;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.Jdbc;
import es.uniovi.asw.entrecine6.central.model.Sale;
import es.uniovi.asw.entrecine6.central.persistence.dao.SaleDao;

public class FindAllSales implements Invoke {

	@Override
	public Object invoke() throws SQLException {
		DataEncryptor encryptor = new DataEncryptor("AS");
		SaleDao dao = PersistenceFactory.getSaleDao();

		dao.setConnection(Jdbc.getCurrentConnection());

		List<Sale> sales = dao.findAll();

		List<Sale> decodedSales = new ArrayList<Sale>();
		
		for (Sale sale : sales) {
			String decodedInfo = encryptor.decrypt(sale.getPaymentInfo());

			Sale decodedSale = new Sale(sale.getId(), sale.getNumberOfSeats(),
					sale.getSession(), decodedInfo);

			decodedSales.add(decodedSale);
		}
		
		return decodedSales;
	}

}
