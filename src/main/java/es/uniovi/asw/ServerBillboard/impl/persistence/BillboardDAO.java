package main.java.es.uniovi.asw.ServerBillboard.impl.persistence;

import java.sql.SQLException;

import main.java.es.uniovi.asw.ServerBillboard.com.model.Billboard;

public interface BillboardDAO {

	public Billboard getBillboard() throws ClassNotFoundException, SQLException;

	public Object setBillboard(Billboard billboard) throws ClassNotFoundException, SQLException;

}
