package impl.uniovi.asw.entrecine6.central.business.billboard;

import java.util.List;

import es.uniovi.asw.entrecine6.central.infrastructure.DBServicesFactory;
import es.uniovi.asw.entrecine6.central.model.Movie;
import es.uniovi.asw.entrecine6.central.persistence.BillboardDBService;

public class BillboardLoader {

	public List<Movie> loadMovies() {
		BillboardDBService service = DBServicesFactory
				.getBillboardDBService();
		return service.loadMovies();
	}

}
