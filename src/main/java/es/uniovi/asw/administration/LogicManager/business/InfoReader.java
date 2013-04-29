package main.java.es.uniovi.asw.entrecine.administration.LogicManager.business;

import main.java.es.uniovi.asw.entrecine.administration.es.business.BillboardService;
import main.java.es.uniovi.asw.entrecine.administration.es.business.SaleService;
import main.java.es.uniovi.asw.entrecine.administration.es.business.ServicesFactory;
import main.java.es.uniovi.asw.entrecine.administration.es.business.UserService;

public class InfoReader implements ServicesFactory {

	@Override
	public BillboardService createBillboardService() {
		// TODO Auto-generated method stub
		return new SimpleBillboarService();
	}

	@Override
	public SaleService createSaleService() {
		// TODO Auto-generated method stub
		return new SimpleSaleService();
	}

	@Override
	public UserService createUserService() {
		// TODO Auto-generated method stub
		return new SimpleUserService();
	}

	

}
