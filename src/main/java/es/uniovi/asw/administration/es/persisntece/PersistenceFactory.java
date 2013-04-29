package main.java.es.uniovi.asw.entrecine.administration.es.persisntece;

public interface PersistenceFactory {
	BillboardDao createBillboardDao();
	SaleDao createSaleDao();
	UserDao creaUserDao();
}
