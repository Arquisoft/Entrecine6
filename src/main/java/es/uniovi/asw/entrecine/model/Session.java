package es.uniovi.asw.entrecine.model;

import java.util.List;
import java.util.Date;

public class Session {
	
	private Long id;
	
	private int theater;
	
	private Date date;
	
	private float startTime;
	
	private float prize;

	public Session(Long id, int theater, Movie movie, int startTime,
			List<Integer> ocuppedSeats) {
		this.id = id;
		this.theater = theater;
		this.startTime = startTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public float setStartTime(float startTime) {
		this.startTime = startTime;
	}

	public float getPrize() {
		return prize;
	}

	public void setPrize(float prize) {
		this.prize = prize;
	}

}
