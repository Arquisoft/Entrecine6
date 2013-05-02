package main.java.es.uniovi.asw.ServerBillboard.impl.persistence;

import java.sql.SQLException;
import java.util.List;

import main.java.es.uniovi.asw.ServerBillboard.com.model.Session;

public interface SessionDAO {

	public List<Session> getSessiones(int id) throws SQLException, ClassNotFoundException;
}
