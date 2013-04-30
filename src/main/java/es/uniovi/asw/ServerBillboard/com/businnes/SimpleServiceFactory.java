package main.java.es.uniovi.asw.ServerBillboard.com.businnes;

import main.java.es.uniovi.asw.ServerBillboard.com.businnes.services.BillboardService;
import main.java.es.uniovi.asw.ServerBillboard.impl.bussines.SimpleBillboardService;

public class SimpleServiceFactory implements ServicesFactory {

	@Override
	public BillboardService createBillboardService() {
		return new SimpleBillboardService();
	}

}
