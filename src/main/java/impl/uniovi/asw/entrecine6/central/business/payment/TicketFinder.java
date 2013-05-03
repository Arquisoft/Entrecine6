package impl.uniovi.asw.entrecine6.central.business.payment;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.infrastructure.DBServicesFactory;
import es.uniovi.asw.entrecine6.central.model.Sale;

public class TicketFinder {

	public boolean validateCode(String ticketCode) {
		Sale sale;
		try {
			sale = DBServicesFactory.getSalesDBService()
					.findByTicket(ticketCode);

			if (sale != null)
				return true;
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		return false;
	}

}
