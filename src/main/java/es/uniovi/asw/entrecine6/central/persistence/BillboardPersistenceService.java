package es.uniovi.asw.entrecine6.central.persistence;

import java.util.List;

import es.uniovi.asw.entrecine6.central.business.listener.BillboardUpdateListener;
import es.uniovi.asw.entrecine6.central.model.Movie;

public interface BillboardPersistenceService {

	List<Movie> loadBillboard();

	void registerServer(BillboardUpdateListener listener);

}