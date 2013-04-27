package es.uniovi.asw.entrecine6.central.model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Billboard implements Serializable{

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
