package main.java.es.uniovi.asw.entrecine.administration.LogicManager.persistence;

import main.java.es.uniovi.asw.entrecine.administration.DataBaseSystem;
import main.java.es.uniovi.asw.entrecine.administration.es.persisntece.BillboardDao;
import main.java.es.uniovi.asw.entrecine.administration.es.persisntece.PersistenceFactory;
import main.java.es.uniovi.asw.entrecine.administration.es.persisntece.SaleDao;
import main.java.es.uniovi.asw.entrecine.administration.es.persisntece.UserDao;



public class SimplePersistenceFactory  implements PersistenceFactory {

	@Override
	public BillboardDao createBillboardDao() {
		// TODO Auto-generated method stub
		return new DataBaseSystem();
	}

	@Override
	public SaleDao createSaleDao() {
		// TODO Auto-generated method stub
		return new DataBaseSystem();
	}

	@Override
	public UserDao creaUserDao() {
		// TODO Auto-generated method stub
		return new DataBaseSystem();
	}

}
