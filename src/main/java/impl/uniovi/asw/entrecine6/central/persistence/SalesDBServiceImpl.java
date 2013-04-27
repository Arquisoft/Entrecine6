package impl.uniovi.asw.entrecine6.central.persistence;

import impl.uniovi.asw.entrecine6.central.persistence.classes.sale.AddTicket;
import impl.uniovi.asw.entrecine6.central.persistence.classes.sale.FindByCode;
import impl.uniovi.asw.entrecine6.central.persistence.classes.sale.SaveSale;
import es.uniovi.asw.entrecine6.central.model.Sale;
import es.uniovi.asw.entrecine6.central.model.Ticket;
import es.uniovi.asw.entrecine6.central.persistence.SalesDBService;

public class SalesDBServiceImpl implements SalesDBService{

	@Override
	public void saveTicket(Ticket ticket) {
		new Summoner().invoke(new AddTicket(ticket));
	}

	@Override
	public Ticket getTicket(String ticketCode) {
		return (Ticket) new Summoner().invoke(new FindByCode(ticketCode));
	}

	@Override
	public int[] saveSale(Sale sale) {
		return (int[]) new Summoner().invoke(new SaveSale(sale));
	}

}
