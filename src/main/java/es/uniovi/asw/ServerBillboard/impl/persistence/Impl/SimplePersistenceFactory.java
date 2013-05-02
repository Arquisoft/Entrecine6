package main.java.es.uniovi.asw.ServerBillboard.impl.persistence.Impl;

import main.java.es.uniovi.asw.ServerBillboard.com.persistence.PersistenceFactory;
import main.java.es.uniovi.asw.ServerBillboard.impl.persistence.BillboardDAO;

public class SimplePersistenceFactory implements PersistenceFactory{

	@Override
	public BillboardDAO createBillboardDAO() {
		return new BillboardJdbcDAO();
	}

	
	
}
