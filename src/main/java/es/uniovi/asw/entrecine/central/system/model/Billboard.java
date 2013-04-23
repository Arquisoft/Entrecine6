package es.uniovi.asw.entrecine.central.system.model;

import java.util.ArrayList;
import java.util.List;

public class Billboard {

	private List<Movie> movies = new ArrayList<Movie>();

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

}
