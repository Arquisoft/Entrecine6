package main.java.es.uniovi.asw.ServerBillboard.impl.bussines;

import java.sql.SQLException;

import main.java.es.uniovi.asw.ServerBillboard.com.businnes.services.BillboardService;
import main.java.es.uniovi.asw.ServerBillboard.com.model.Billboard;
import main.java.es.uniovi.asw.ServerBillboard.impl.persistence.BillboardDAO;

public class SimpleBillboardService implements BillboardService{

	@Override
	public Billboard getBillboard() throws ClassNotFoundException, SQLException {
		return new BillboardDAO().getBillboard();
	}

	@Override
	public void setBillboard(Billboard billboard) throws ClassNotFoundException, SQLException {
		new BillboardDAO().setBillboard(billboard);
	}

}
