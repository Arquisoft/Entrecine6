package es.uniovi.asw.entrecine6.central.model;

import java.io.Serializable;
import java.util.List;

public class Billboard implements Serializable{

	private static final long serialVersionUID = 6813750168951988677L;
	
	private List<Movie> movies;

	public Billboard(List<Movie> movies) {
		this.movies = movies;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

}
