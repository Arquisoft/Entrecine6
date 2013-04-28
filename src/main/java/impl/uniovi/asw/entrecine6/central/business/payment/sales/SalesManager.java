package impl.uniovi.asw.entrecine6.central.business.payment.sales;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.infrastructure.DBServicesFactory;
import es.uniovi.asw.entrecine6.central.model.Sale;
import es.uniovi.asw.entrecine6.central.persistence.SalesDBService;

public class SalesManager {
	
	public static int[] saveSale(Sale sale) throws BusinessException{
		SalesDBService service = DBServicesFactory
				.getSalesDBService();
		return service.saveSale(sale);
	}
	

}
