package main.java.es.uniovi.asw.ServerBillboard.impl.bussines;

import java.sql.SQLException;

import main.java.es.uniovi.asw.ServerBillboard.com.businnes.services.BillboardService;
import main.java.es.uniovi.asw.ServerBillboard.com.model.Billboard;
import main.java.es.uniovi.asw.ServerBillboard.impl.infrastructure.Factories;

public class SimpleBillboardService implements BillboardService{

	@Override
	public Billboard getBillboard() throws ClassNotFoundException, SQLException {
		return Factories.persistence.createBillboardDAO().getBillboard();
	}

	@Override
	public void setBillboard(Billboard billboard) throws ClassNotFoundException, SQLException {
		Factories.persistence.createBillboardDAO().setBillboard(billboard);
	}

}
