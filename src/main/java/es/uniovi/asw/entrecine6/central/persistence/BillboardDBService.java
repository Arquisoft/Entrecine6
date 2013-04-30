package es.uniovi.asw.entrecine6.central.persistence;

import java.util.List;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.business.listener.BillboardUpdateListener;
import es.uniovi.asw.entrecine6.central.model.Movie;

public interface BillboardDBService {

	List<Movie> loadMovies() throws BusinessException;

	void registerServer(BillboardUpdateListener listener)
			throws BusinessException;

	void updateBilboard(List<Movie> billboard) throws BusinessException;

}
