package main.java.es.uniovi.asw.ServerBillboard.impl.persistence.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.es.uniovi.asw.ServerBillboard.com.model.Billboard;
import main.java.es.uniovi.asw.ServerBillboard.com.model.Movie;
import main.java.es.uniovi.asw.ServerBillboard.com.model.Session;
import main.java.es.uniovi.asw.ServerBillboard.impl.infrastructure.Conexiones;
import main.java.es.uniovi.asw.ServerBillboard.impl.infrastructure.Factories;
import main.java.es.uniovi.asw.ServerBillboard.impl.persistence.MovieDAO;

public class MovieJdbcDAO implements MovieDAO {

	@Override
	public List<Movie> getMovies() throws ClassNotFoundException, SQLException {
		List<Movie> peliculas = new ArrayList<Movie>();
		List<Session> sesionesPelicula = new ArrayList<Session>();
		Movie pelicula = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = Conexiones.getConectionLocalDataBase();
		try {
			ps = con.prepareStatement("Select * from pelicula");
			rs = ps.executeQuery();
			while (rs.next()) {
				pelicula = new Movie();
				pelicula.setId(rs.getInt("id"));
				pelicula.setName(rs.getString("nombre"));
				pelicula.setSinopsis(rs.getString("sinopsis"));
				pelicula.setDuration(rs.getInt("genero"));
				pelicula.setGenero(rs.getString("genero"));
				sesionesPelicula = Factories.persistence.createSessionDAO()
						.getSessiones(rs.getInt("id"));
				pelicula.setSessions(sesionesPelicula);

				peliculas.add(pelicula);
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
		return peliculas;
	}

	@Override
	public Object setMovies(Billboard billboard) throws ClassNotFoundException,
			SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = Conexiones.getConectionLocalDataBase();
		try {
			ps = con.prepareStatement("delete from nombretabla where 1");
			rs = ps.executeQuery();

			for (Movie pelicula : billboard.getMovies()) {
				ps = con.prepareStatement("insert into pelicula(id,nombre,sinopsis) values ("
						+ pelicula.getId()
						+ ","
						+ pelicula.getName()
						+ ","
						+ pelicula.getSinopsis() + ")");
				ps.executeUpdate();
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
		return null;
	}
}
