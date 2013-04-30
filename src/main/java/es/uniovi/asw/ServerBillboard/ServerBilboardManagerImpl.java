package main.java.es.uniovi.asw.ServerBillboard;

import java.sql.SQLException;

import main.java.es.uniovi.asw.ServerBillboard.com.model.Billboard;
import main.java.es.uniovi.asw.ServerBillboard.impl.infrastructure.Factories;
import main.java.es.uniovi.asw.entrecine.interfaces.WebServerToCentralSystem;

public class ServerBilboardManagerImpl implements ServerBillboardManager{

	private WebServerToCentralSystem centralSystem = null;

	private Billboard requestCentralBillboard() {
		return centralSystem.requestBillboard();
	}

	public String Connect() {
		//Queda por poner correctamente esta direccion
		return "localhost:9000/index";
	}

	public Billboard getLocalBillboard() throws ClassNotFoundException, SQLException {
		return Factories.services.createBillboardService().getBillboard();
	}

	public void setLocalBillboard() throws ClassNotFoundException, SQLException {
		Factories.services.createBillboardService().setBillboard(requestCentralBillboard());
	}
	
	

}
