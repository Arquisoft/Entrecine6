package es.uniovi.asw.entrecine6.central.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Session implements Serializable{
	
	private Long id;
	
	private Long idMovie;
	
	private int theater;
	
	private Date date;
	
	private float startTime;
	
	private float prize;

	public Session(Long id, Long idMovie, int theater, Date date, float startTime, float prize) {
		this.id = id;
		this.idMovie = idMovie;
		this.theater = theater;
		this.date = date;
		this.startTime = startTime;
		this.prize = prize;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(Long idMovie) {
		this.idMovie = idMovie;
	}

	public int getTheater() {
		return theater;
	}

	public void setTheater(int theater) {
		this.theater = theater;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public Date getDate(){
		return date;
	}

	public float getStartTime() {
		return startTime;
	}

	public void setStartTime(float startTime) {
		this.startTime = startTime;
	}

	public float getPrize() {
		return prize;
	}

	public void setPrize(float prize) {
		this.prize = prize;
	}

}
