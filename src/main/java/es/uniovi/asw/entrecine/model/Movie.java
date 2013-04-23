package es.uniovi.asw.entrecine.model;

import java.awt.Image;

public class Movie {
	
	private Long id;
	
	private Image poster;
	
	private String name;
	
	private String sinopsis;
	
	private int duration;
	
	private int prize;

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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}
	

}
