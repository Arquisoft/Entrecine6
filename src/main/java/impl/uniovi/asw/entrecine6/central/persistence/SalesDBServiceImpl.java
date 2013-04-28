package impl.uniovi.asw.entrecine6.central.persistence;

import java.util.List;

import impl.uniovi.asw.entrecine6.central.persistence.classes.sale.AddTicket;
import impl.uniovi.asw.entrecine6.central.persistence.classes.sale.FindAllSales;
import impl.uniovi.asw.entrecine6.central.persistence.classes.sale.FindTicketByCode;
import impl.uniovi.asw.entrecine6.central.persistence.classes.sale.SaveSale;
import impl.uniovi.asw.entrecine6.central.persistence.classes.user.FindAllUsers;
import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.model.Sale;
import es.uniovi.asw.entrecine6.central.model.Ticket;
import es.uniovi.asw.entrecine6.central.model.User;
import es.uniovi.asw.entrecine6.central.persistence.SalesDBService;

public class SalesDBServiceImpl implements SalesDBService{

	@Override
	public void saveTicket(Ticket ticket) throws BusinessException {
		new Summoner().invoke(new AddTicket(ticket));
	}

	@Override
	public Ticket getTicket(String ticketCode) throws BusinessException {
		return (Ticket) new Summoner().invoke(new FindTicketByCode(ticketCode));
	}

	@Override
	public int[] saveSale(Sale sale) throws BusinessException {
		return (int[]) new Summoner().invoke(new SaveSale(sale));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sale> findAll() throws BusinessException {
		return (List<Sale>) new Summoner().invoke(new FindAllSales());
	}

}
