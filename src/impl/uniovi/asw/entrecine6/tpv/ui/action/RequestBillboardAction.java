package impl.uniovi.asw.entrecine6.tpv.ui.action;

import impl.uniovi.asw.entrecine6.tpv.TPVActions;
import es.uniovi.asw.entrecine6.tpv.model.Billboard;
import es.uniovi.asw.entrecine6.tpv.model.Movie;
import es.uniovi.asw.entrecine6.tpv.util.BusinessException;
import es.uniovi.asw.entrecine6.tpv.util.menu.Action;

public class RequestBillboardAction implements Action {

	@Override
	public void execute() throws BusinessException {
		TPVActions tpva = new TPVActions();
		Billboard b = tpva.getBillboard();
		if (b != null && b.getMovies() != null) {
			System.out.println("Cartelera:");
			for (Movie m : b.getMovies())
				System.out.println(m.toString());
		} else
			System.err.println("No se ha podido recuperar la cartelera");
	}
}
