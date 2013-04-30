package main.java.es.uniovi.asw.ServerBillboard.impl.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.es.uniovi.asw.ServerBillboard.com.model.Billboard;
import main.java.es.uniovi.asw.ServerBillboard.impl.infrastructure.Conexiones;

public class BillboardDAO {

	public Billboard getBillboard() throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = Conexiones.getConectionLocalDataBase();
		try {
			ps = con.prepareStatement("consulta");
			rs = ps.executeQuery();
			while (rs.next()) {
				// Categoria categoria = new Categoria();
				// categoria.setId(rs.getInt("id"));
				// categoria.setTitulo(rs.getString("titulo"));
				// categoria.setNumeroDeTemas(rs.getString("numerodetemas"));
				// categoria.setNumeroDeMensajes(rs.getString("numeromensajes"));
				// categoria.setDescripcion(rs.getString("descripcion"));
				// categorias.add(categoria);
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

	public Object setBillboard(Billboard billboard) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = Conexiones.getConectionLocalDataBase();
		try {
			ps = con.prepareStatement("consulta");
			rs = ps.executeQuery();
			while (rs.next()) {
				// Categoria categoria = new Categoria();
				// categoria.setId(rs.getInt("id"));
				// categoria.setTitulo(rs.getString("titulo"));
				// categoria.setNumeroDeTemas(rs.getString("numerodetemas"));
				// categoria.setNumeroDeMensajes(rs.getString("numeromensajes"));
				// categoria.setDescripcion(rs.getString("descripcion"));
				// categorias.add(categoria);
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
