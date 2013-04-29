package main.java.es.uniovi.asw.entrecine.administration.LogicManager.business.classes;

import java.util.List;

import main.java.es.uniovi.asw.entrecine.administration.es.infraestructure.Factories;
import main.java.es.uniovi.asw.entrecine.administration.es.persisntece.SaleDao;
import es.uniovi.asw.entrecine.central.system.model.Sale;

public class SalesFindAll {
	public List<Sale> sales() {
		SaleDao dao = Factories.persistence.createSaleDao();
		return dao.getSales();
		
	}

}
