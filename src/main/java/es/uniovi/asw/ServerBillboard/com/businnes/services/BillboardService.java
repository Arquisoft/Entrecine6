package main.java.es.uniovi.asw.ServerBillboard.com.businnes.services;

import java.sql.SQLException;

import main.java.es.uniovi.asw.ServerBillboard.com.model.Billboard;

public interface BillboardService {
	
	public Billboard getBillboard() throws ClassNotFoundException, SQLException;
	
	public void setBillboard(Billboard billboard) throws ClassNotFoundException, SQLException;

}
