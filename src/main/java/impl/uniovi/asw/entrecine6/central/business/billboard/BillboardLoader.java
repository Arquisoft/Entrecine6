package impl.uniovi.asw.entrecine6.central.business.billboard;

import java.util.List;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.infrastructure.DBServicesFactory;
import es.uniovi.asw.entrecine6.central.model.Movie;
import es.uniovi.asw.entrecine6.central.persistence.BillboardDBService;

public class BillboardLoader {

	public List<Movie> loadMovies() {
		BillboardDBService service = DBServicesFactory
				.getBillboardDBService();
		try {
			return service.loadMovies();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
