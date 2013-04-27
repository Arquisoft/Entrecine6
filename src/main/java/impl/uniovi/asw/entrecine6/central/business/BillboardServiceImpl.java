package impl.uniovi.asw.entrecine6.central.business;

import impl.uniovi.asw.entrecine6.central.business.billboard.BillboardLoader;
import impl.uniovi.asw.entrecine6.central.business.billboard.BillboardUpdateConnecter;

import java.util.List;

import es.uniovi.asw.entrecine6.central.business.BillboardService;
import es.uniovi.asw.entrecine6.central.business.listener.BillboardUpdateListener;
import es.uniovi.asw.entrecine6.central.model.Billboard;
import es.uniovi.asw.entrecine6.central.model.Movie;

public class BillboardServiceImpl implements BillboardService {

	@Override
	public Billboard getServerBillboard() {
		List<Movie> movies = getMovies();
		return new Billboard(movies);
	}

	@Override
	public Billboard getTPVBillboard() {
		List<Movie> movies = getMovies();
		return new Billboard(movies);
	}

	@Override
	public void connectBillboard(BillboardUpdateListener listener) {
		new BillboardUpdateConnecter().connect(listener);
		
	}
	
	private List<Movie> getMovies(){
		return new BillboardLoader().loadMovies(); 
	}

}
