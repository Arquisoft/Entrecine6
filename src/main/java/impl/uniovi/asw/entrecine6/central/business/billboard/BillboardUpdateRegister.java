package impl.uniovi.asw.entrecine6.central.business.billboard;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.infrastructure.DBServicesFactory;
import es.uniovi.asw.entrecine6.central.persistence.BillboardDBService;

public class BillboardUpdateRegister {

	public void registerServer(String url) {
		BillboardDBService service = DBServicesFactory
				.getBillboardDBService();
		try {
			service.registerURL(url);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

}
