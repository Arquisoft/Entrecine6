package es.uniovi.asw.entrecine6.central.model;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.imageio.ImageIO;

public class Movie implements Serializable {

	private static final long serialVersionUID = 1456431466098537183L;

	private Long id;

	private byte[] poster;

	private String name;

	private String sinopsis;

	private String genre;

	private int duration;

	private List<Session> sessions;

	public Movie(Long id, byte[] poster, String name, String sinopsis,
			String genre, int duration, List<Session> sessions) {
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
		try {
			return ImageIO.read(new ByteArrayInputStream(poster));
		} catch (IOException e) {
		}
		return null;
	}

	public byte[] getPosterBytes() {
		return poster;
	}

	public void setPoster(byte[] poster) {
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
