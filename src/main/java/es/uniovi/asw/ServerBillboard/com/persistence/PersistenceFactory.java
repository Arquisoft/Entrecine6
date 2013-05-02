package main.java.es.uniovi.asw.ServerBillboard.com.persistence;

import main.java.es.uniovi.asw.ServerBillboard.impl.persistence.BillboardDAO;

public interface PersistenceFactory {
	
	public BillboardDAO createBillboardDAO();

}
