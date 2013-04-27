package impl.uniovi.asw.entrecine6.central.business.billboard;

import es.uniovi.asw.entrecine6.central.business.listener.BillboardUpdateListener;
import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.persistence.BillboardPersistenceService;

public class BillboardUpdateConnecter {

	public void connect(BillboardUpdateListener listener) {
		BillboardPersistenceService service = PersistenceFactory
				.getBillboardPersistenceService();
		service.registerServer(listener);
	}

}
