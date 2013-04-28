package es.uniovi.asw.entrecine6.central.infrastructure;

import impl.uniovi.asw.entrecine6.central.persistence.BillboardDBServiceImpl;
import impl.uniovi.asw.entrecine6.central.persistence.SalesDBServiceImpl;
import impl.uniovi.asw.entrecine6.central.persistence.UserDBServiceImpl;
import es.uniovi.asw.entrecine6.central.persistence.BillboardDBService;
import es.uniovi.asw.entrecine6.central.persistence.SalesDBService;
import es.uniovi.asw.entrecine6.central.persistence.UserDBService;

public class DBServicesFactory {
	
	public static SalesDBService getSalesDBService(){
		return new SalesDBServiceImpl();
	}
	
	public static UserDBService getUserDBService(){
		return new UserDBServiceImpl();
	}
	
	public static BillboardDBService getBillboardDBService(){
		return new BillboardDBServiceImpl();
	}

}
