package impl.uniovi.asw.entrecine6.central.business.billboard;

import java.util.List;

import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.model.Movie;
import es.uniovi.asw.entrecine6.central.persistence.BillboardPersistenceService;

public class BillboardLoader {

	public List<Movie> loadBillboard() {
		BillboardPersistenceService service = PersistenceFactory
				.getBillboardPersistenceService();
		return service.loadBillboard();
	}

}
