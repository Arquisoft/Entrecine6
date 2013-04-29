package main.java.es.uniovi.asw.entrecine.administration.LogicManager.business.classes;

import main.java.es.uniovi.asw.entrecine.administration.es.infraestructure.Factories;
import main.java.es.uniovi.asw.entrecine.administration.es.persisntece.BillboardDao;
import es.uniovi.asw.entrecine.central.system.model.Billboard;

public class BillboardFind {
	public Billboard billboard(){
		BillboardDao dao=Factories.persistence.createBillboardDao();
	return	dao.getRawBillboard();
	}

}
