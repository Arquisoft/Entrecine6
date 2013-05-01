package impl.uniovi.asw.entrecine6.central.persistence.classes.movie;

import impl.uniovi.asw.entrecine6.central.persistence.Invoke;
import impl.uniovi.asw.entrecine6.central.persistence.classes.movie.server.ServerRegister;

public class RegisterURLServer implements Invoke{
	
	private String url;
	
	public RegisterURLServer(String url) {
		this.url = url;
	}

	public Object invoke() {
		ServerRegister.addServerURL(url);
		return null;
	}

}
