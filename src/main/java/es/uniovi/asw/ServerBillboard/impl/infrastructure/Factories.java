package main.java.es.uniovi.asw.ServerBillboard.impl.infrastructure;

import main.java.es.uniovi.asw.ServerBillboard.com.businnes.ServicesFactory;
import main.java.es.uniovi.asw.ServerBillboard.com.businnes.SimpleServiceFactory;
import main.java.es.uniovi.asw.ServerBillboard.com.persistence.PersistenceFactory;
import main.java.es.uniovi.asw.ServerBillboard.impl.persistence.Impl.SimplePersistenceFactory;


public class Factories {

	public static ServicesFactory services = new SimpleServiceFactory();
	
	public static PersistenceFactory persistence = new SimplePersistenceFactory();
	
}
