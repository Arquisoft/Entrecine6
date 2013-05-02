package main.java.es.uniovi.asw.ServerBillboard.impl.bussines;

import java.sql.SQLException;
import java.util.List;

import main.java.es.uniovi.asw.ServerBillboard.com.businnes.services.BillboardService;
import main.java.es.uniovi.asw.ServerBillboard.com.model.Billboard;
import main.java.es.uniovi.asw.ServerBillboard.com.model.Movie;
import main.java.es.uniovi.asw.ServerBillboard.impl.infrastructure.Factories;

public class SimpleBillboardService implements BillboardService{

	@Override
	public Billboard getBillboard() throws ClassNotFoundException, SQLException {
		List<Movie> peliculas = Factories.persistence.createMovieDAO().getMovies();
		return new Billboard(peliculas);
	}

	@Override
	public void setBillboard(Billboard billboard) throws ClassNotFoundException, SQLException {
		Factories.persistence.createMovieDAO().setMovies(billboard);
	}

}
