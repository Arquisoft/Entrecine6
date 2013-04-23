package es.uniovi.asw.entrecine.model;

import java.util.ArrayList;
import java.util.List;

public class Billboard {
	
	private List<Session> sessions = new ArrayList<Session>();

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

}
