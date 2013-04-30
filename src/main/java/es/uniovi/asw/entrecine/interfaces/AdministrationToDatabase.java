package main.java.es.uniovi.asw.entrecine.interfaces;

import java.util.List;

import javax.sql.rowset.CachedRowSet;

import main.java.es.uniovi.asw.ServerBillboard.com.model.Sale;
import main.java.es.uniovi.asw.ServerBillboard.com.model.User;

public interface AdministrationToDatabase {
	
	List<User> getUsers();
	
	List<Sale> getSales();
	
	CachedRowSet getBillboard();
	
	void updateBillboard(CachedRowSet billboard);

}
