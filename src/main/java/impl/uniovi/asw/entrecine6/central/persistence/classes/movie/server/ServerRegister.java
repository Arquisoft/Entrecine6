package impl.uniovi.asw.entrecine6.central.persistence.classes.movie.server;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.entrecine6.central.business.listener.BillboardUpdateListener;

public class ServerRegister {

	private static ServerRegister instance;

	private List<BillboardUpdateListener> serversListeners;

	private ServerRegister() {
		this.serversListeners = new ArrayList<BillboardUpdateListener>();
	}

	public static void addServer(BillboardUpdateListener listener) {
		getInstance().serversListeners.add(listener);
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
		for (BillboardUpdateListener listener : serversListeners)
			listener.update();
	}

}
