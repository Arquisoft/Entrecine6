package es.uniovi.asw.entrecine6.central.gateway;

import java.util.List;

import javax.sql.rowset.CachedRowSet;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.model.Sale;
import es.uniovi.asw.entrecine6.central.model.User;

public interface AdministrationGateway {

	List<User> getUsers() throws BusinessException;

	List<Sale> getSales() throws BusinessException;

	CachedRowSet getBillboard() throws BusinessException;

	void updateBillboard(CachedRowSet billboard) throws BusinessException;

}
