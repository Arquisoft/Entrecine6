package impl.uniovi.asw.entrecine6.central.persistence.classes.movie;

import impl.uniovi.asw.entrecine6.central.persistence.Invoke;
import impl.uniovi.asw.entrecine6.central.persistence.classes.movie.server.ServerRegister;
import es.uniovi.asw.entrecine6.central.business.listener.BillboardUpdateListener;

public class RegisterServerBillboard implements Invoke{
	
	private BillboardUpdateListener listener;
	
	public RegisterServerBillboard(BillboardUpdateListener listener) {
		this.listener = listener;
	}

	public Object invoke() {
		ServerRegister.addServer(listener);
		return null;
	}

}
