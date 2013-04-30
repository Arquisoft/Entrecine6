package impl.uniovi.asw.entrecine6.central.business.billboard;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.business.listener.BillboardUpdateListener;
import es.uniovi.asw.entrecine6.central.infrastructure.DBServicesFactory;
import es.uniovi.asw.entrecine6.central.persistence.BillboardDBService;

public class BillboardUpdateConnecter {

	public void connect(BillboardUpdateListener listener) {
		BillboardDBService service = DBServicesFactory
				.getBillboardDBService();
		try {
			service.registerServer(listener);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

}
