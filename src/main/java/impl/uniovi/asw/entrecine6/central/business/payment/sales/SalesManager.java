package impl.uniovi.asw.entrecine6.central.business.payment.sales;

import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.model.Sale;
import es.uniovi.asw.entrecine6.central.persistence.SalesPersistenceService;

public class SalesManager {
	
	public static int[] saveSale(Sale sale){
		SalesPersistenceService service = PersistenceFactory
				.getSalesPersistenceService();
		return service.saveSale(sale);
	}
	

}
