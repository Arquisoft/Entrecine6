package es.uniovi.asw.entrecine6.central.business;

import es.uniovi.asw.entrecine6.central.business.listener.BillboardUpdateListener;
import es.uniovi.asw.entrecine6.central.model.Billboard;

public interface BillboardService {
	
	Billboard getServerBillboard();
	
	Billboard getTPVBillboard();
	
	void connectBillboard(BillboardUpdateListener listener);

}
