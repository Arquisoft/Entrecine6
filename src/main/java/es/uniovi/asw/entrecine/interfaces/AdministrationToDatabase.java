package es.uniovi.asw.entrecine.interfaces;

import java.util.List;

import javax.sql.rowset.CachedRowSet;

import es.uniovi.asw.entrecine.model.Sale;
import es.uniovi.asw.entrecine.model.User;

public interface AdministrationToDatabase {
	
	List<User> getUsers();
	
	List<Sale> getSales();
	
	CachedRowSet getBillboard();
	
	void updateBillboard(CachedRowSet billboard);

}
