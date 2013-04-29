package main.java.es.uniovi.asw.entrecine.administration.es.business;

import java.util.List;

import es.uniovi.asw.entrecine.central.system.model.Sale;

public interface SaleService {
	List<Sale> getSales();
	Sale findById (Long id);
}
