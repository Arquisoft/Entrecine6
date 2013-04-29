package main.java.es.uniovi.asw.entrecine.administration.es.infraestructure;

import main.java.es.uniovi.asw.entrecine.administration.LogicManager.business.CommitManager;
import main.java.es.uniovi.asw.entrecine.administration.LogicManager.business.InfoReader;
import main.java.es.uniovi.asw.entrecine.administration.LogicManager.persistence.SimplePersistenceCommitFactory;
import main.java.es.uniovi.asw.entrecine.administration.LogicManager.persistence.SimplePersistenceFactory;
import main.java.es.uniovi.asw.entrecine.administration.es.business.ServicesCommitFactory;
import main.java.es.uniovi.asw.entrecine.administration.es.business.ServicesFactory;
import main.java.es.uniovi.asw.entrecine.administration.es.persisntece.BillboardCommitDao;
import main.java.es.uniovi.asw.entrecine.administration.es.persisntece.PersistenceCommitFactory;
import main.java.es.uniovi.asw.entrecine.administration.es.persisntece.PersistenceFactory;



public class Factories {
	public static ServicesFactory services = new InfoReader();
	public static PersistenceFactory persistence = new SimplePersistenceFactory();
	public static ServicesCommitFactory servicesCommit=new CommitManager();
	public static PersistenceCommitFactory persistenceCommit=new SimplePersistenceCommitFactory() ;
	
}
