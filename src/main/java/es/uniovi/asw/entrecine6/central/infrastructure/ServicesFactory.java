package es.uniovi.asw.entrecine6.central.infrastructure;

import es.uniovi.asw.entrecine6.central.business.*;
import impl.uniovi.asw.entrecine6.central.business.*;

public class ServicesFactory {

	public static BillboardService getBillboardService(){
		return new BillboardServiceImpl();
	}
	
	public static PaymentService getPaymentService(){
		return new PaymentServiceImpl();
	}
	
	public static UsersService getUsersService(){
		return new UsersServiceImpl();
	}
}
