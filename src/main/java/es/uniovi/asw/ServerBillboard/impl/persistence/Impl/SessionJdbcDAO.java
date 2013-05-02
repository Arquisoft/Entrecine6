package main.java.es.uniovi.asw.ServerBillboard.impl.persistence.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.es.uniovi.asw.ServerBillboard.com.model.Session;
import main.java.es.uniovi.asw.ServerBillboard.impl.infrastructure.Conexiones;
import main.java.es.uniovi.asw.ServerBillboard.impl.persistence.SessionDAO;

public class SessionJdbcDAO implements SessionDAO {

	@Override
	public List<Session> getSessiones(int id) throws SQLException,
			ClassNotFoundException {
		List<Session> sesionesPelicula = new ArrayList<Session>();
		Session session = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = Conexiones.getConectionLocalDataBase();
		try {
			ps = con.prepareStatement("Select * from session where id_movie = ?");
			ps.setInt(1, id);

			rs = ps.executeQuery();
			while (rs.next()) {
				session = new Session();

				session.setId(rs.getInt("id"));

				sesionesPelicula.add(session);
			}
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception ex) {
				}
			}
			;
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception ex) {
				}
			}
			;
			if (con != null) {
				try {
					con.close();
				} catch (Exception ex) {
				}
			}
			;
		}
		return sesionesPelicula;
	}

}
