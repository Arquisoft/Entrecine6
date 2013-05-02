package main.java.es.uniovi.asw.ServerBillboard.impl.persistence;

import java.sql.SQLException;
import java.util.List;

import main.java.es.uniovi.asw.ServerBillboard.com.model.Billboard;
import main.java.es.uniovi.asw.ServerBillboard.com.model.Movie;

public interface MovieDAO {

	public List<Movie> getMovies() throws ClassNotFoundException, SQLException;

	public Object setMovies(Billboard billboard) throws ClassNotFoundException, SQLException;

}
