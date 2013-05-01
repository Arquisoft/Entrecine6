package impl.uniovi.asw.entrecine6.tpv.ui.action;

import impl.uniovi.asw.entrecine6.tpv.TPVActions;
import es.uniovi.asw.entrecine6.tpv.util.BusinessException;
import es.uniovi.asw.entrecine6.tpv.util.console.Console;
import es.uniovi.asw.entrecine6.tpv.util.menu.Action;

public class CheckTicketAction implements Action {

	@Override
	public void execute() throws BusinessException {
		String code = Console.readString("Codigo del Ticket");

		TPVActions tpva = new TPVActions();
		if (tpva.checkTicket(code))
			System.out.println("El ticket se ha validado satisfactoriamente");
		else
			System.err.println("El ticket NO se ha podido validar");
	}
}
