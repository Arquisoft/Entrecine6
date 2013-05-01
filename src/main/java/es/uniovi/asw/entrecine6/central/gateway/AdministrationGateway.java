package es.uniovi.asw.entrecine6.central.gateway;

import java.rmi.Remote;
import java.util.List;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.model.Movie;
import es.uniovi.asw.entrecine6.central.model.Sale;
import es.uniovi.asw.entrecine6.central.model.User;

public interface AdministrationGateway extends Remote{

	List<User> getUsers() throws BusinessException;

	List<Sale> getSales() throws BusinessException;

	List<Movie> getBillboard() throws BusinessException;

	void updateBillboard(List<Movie> billboard) throws BusinessException;

}
