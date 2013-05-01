package es.uniovi.asw.entrecine6.central.persistence.dao;

import java.sql.Connection;
import java.util.List;

import es.uniovi.asw.entrecine6.central.model.Session;
import es.uniovi.asw.entrecine6.central.persistence.exception.NotPersistedException;

public interface SessionDao {

	void setConnection(Connection con);

	List<Session> findByMovie(Long idMovie);

	void update(Session session) throws NotPersistedException;
	
	void save(Session session);
	
}
