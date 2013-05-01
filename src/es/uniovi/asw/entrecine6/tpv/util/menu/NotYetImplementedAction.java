package es.uniovi.asw.entrecine6.tpv.util.menu;

import es.uniovi.asw.entrecine6.tpv.util.BusinessException;



public class NotYetImplementedAction implements Action {

	@Override
	public void execute() throws BusinessException {
		System.err.println("Opción no implementada");
	}

}
