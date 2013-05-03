package es.uniovi.asw.entrecine6.central.persistence;

import java.util.List;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.model.Sale;
import es.uniovi.asw.entrecine6.central.model.Ticket;

public interface SalesDBService {

	void saveTicket(Ticket ticket) throws BusinessException;

	Sale findByTicket(String ticketCode) throws BusinessException;

	int[] saveSale(Sale sale) throws BusinessException;

	List<Sale> findAll() throws BusinessException;

}
