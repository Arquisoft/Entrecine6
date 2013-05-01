package es.uniovi.asw.entrecine6.tpv.model;

import java.util.List;

public class Billboard {

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
