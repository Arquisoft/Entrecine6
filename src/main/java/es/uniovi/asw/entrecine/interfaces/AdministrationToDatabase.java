package es.uniovi.asw.entrecine.interfaces;

import javax.sql.rowset.CachedRowSet;

public interface AdministrationToDatabase {
	
	CachedRowSet getUsers();
	
	CachedRowSet getSales();
	
	CachedRowSet getBillboard();
	
	void updateBillboard(CachedRowSet billboard);

}
