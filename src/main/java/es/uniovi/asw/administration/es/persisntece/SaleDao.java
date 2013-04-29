package main.java.es.uniovi.asw.entrecine.administration.es.persisntece;

import java.util.List;

import es.uniovi.asw.entrecine.central.system.model.Sale;

public interface SaleDao {
	List<Sale> getSales();
	Sale findById (Long id);
}
