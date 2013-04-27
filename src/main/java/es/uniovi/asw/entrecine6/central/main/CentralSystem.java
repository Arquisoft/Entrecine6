package es.uniovi.asw.entrecine6.central.main;

import impl.uniovi.asw.entrecine6.central.gateway.TPVGatewayImpl;
import impl.uniovi.asw.entrecine6.central.gateway.WebServerGatewayImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import es.uniovi.asw.entrecine6.central.gateway.TPVGateway;
import es.uniovi.asw.entrecine6.central.gateway.WebServerGateway;

public class CentralSystem {

	private static String TPV_REGISTRY_NAME = "TPV";
	private static String WEBSERVER_REGISTRY_NAME = "WEBSERVER";

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			TPVGateway tpvGateway = new TPVGatewayImpl();
			TPVGateway tpvStub = (TPVGateway) UnicastRemoteObject.exportObject(
					tpvGateway, 1000);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(TPV_REGISTRY_NAME, tpvStub);

			System.out.println("TPV bound");

			WebServerGateway webGateway = new WebServerGatewayImpl();
			WebServerGateway webStub = (WebServerGateway) UnicastRemoteObject
					.exportObject(webGateway, 1001);
			registry.rebind(WEBSERVER_REGISTRY_NAME, webStub);

			System.out.println("WebServer bound");
		} catch (Exception e) {
			System.err.println("Oooooooooooooooops");
			e.printStackTrace();
		}
	}

}
