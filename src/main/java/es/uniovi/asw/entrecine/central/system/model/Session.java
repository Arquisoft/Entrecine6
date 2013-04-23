package es.uniovi.asw.entrecine.central.system.model;

import java.util.List;

public class Session {
	
	private Long id;
	
	private int theater;
	
	private int startTime;

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

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

}
