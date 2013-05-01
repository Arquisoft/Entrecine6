package impl.uniovi.asw.entrecine6.central.persistence.classes.movie.server;

import java.util.ArrayList;
import java.util.List;

public class ServerRegister {

	private static ServerRegister instance;

	private List<String> serverURLs;

	private ServerRegister() {
		this.serverURLs = new ArrayList<String>();
	}

	public static void addServerURL(String url) {
		getInstance().serverURLs.add(url);
	}

	public static void notifyServers() {
		getInstance().updateServers();
	}

	private static ServerRegister getInstance() {
		if (instance == null) {
			instance = new ServerRegister();
		}
		return instance;
	}

	private void updateServers() {
		for (String url : serverURLs){
		}
			
	}

}
