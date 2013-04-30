package impl.uniovi.asw.entrecine6.central.persistence;

import impl.uniovi.asw.entrecine6.central.persistence.classes.movie.FindAllMovies;
import impl.uniovi.asw.entrecine6.central.persistence.classes.movie.RegisterServerBillboard;
import impl.uniovi.asw.entrecine6.central.persistence.classes.movie.UpdateBillboard;

import java.util.List;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.business.listener.BillboardUpdateListener;
import es.uniovi.asw.entrecine6.central.model.Movie;
import es.uniovi.asw.entrecine6.central.persistence.BillboardDBService;

public class BillboardDBServiceImpl implements BillboardDBService {

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> loadMovies() throws BusinessException {
		return (List<Movie>) new Summoner().invoke(new FindAllMovies());
	}

	@Override
	public void registerServer(BillboardUpdateListener listener) throws BusinessException {
		new Summoner().invoke(new RegisterServerBillboard(listener));
	}

	@Override
	public void updateBilboard(List<Movie> billboard) throws BusinessException {
		new Summoner().invoke(new UpdateBillboard(billboard));
	}

}
