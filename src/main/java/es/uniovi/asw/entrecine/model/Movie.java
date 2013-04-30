package es.uniovi.asw.entrecine.model;

import java.awt.Image;
import java.util.List;

public class Movie {
	
	private Long id;
	
	private Image poster;
	
	private String name;
	
	private String sinopsis;
	
	private String genre;
	
	private int duration;
	
	private List<Session> sessions;

	public Movie(Long id, Image poster, String name, String sinopsis, String genre,
			int duration, List<Session> sessions) {
		this.id = id;
		this.poster = poster;
		this.name = name;
		this.sinopsis = sinopsis;
		this.genre = genre;
		this.duration = duration;
		this.sessions = sessions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Image getPoster() {
		return poster;
	}

	public void setPoster(Image poster) {
		this.poster = poster;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

}
