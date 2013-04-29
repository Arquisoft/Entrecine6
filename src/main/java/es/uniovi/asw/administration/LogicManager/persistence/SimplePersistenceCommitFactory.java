package main.java.es.uniovi.asw.entrecine.administration.LogicManager.persistence;

import main.java.es.uniovi.asw.entrecine.administration.DataBaseSystem;
import main.java.es.uniovi.asw.entrecine.administration.es.persisntece.BillboardCommitDao;
import main.java.es.uniovi.asw.entrecine.administration.es.persisntece.PersistenceCommitFactory;

public class SimplePersistenceCommitFactory implements PersistenceCommitFactory  {

	@Override
	public BillboardCommitDao creteBillboardCommitDao() {
		// TODO Auto-generated method stub
		return new DataBaseSystem();
	}

}
