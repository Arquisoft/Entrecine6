package main.java.es.uniovi.asw.entrecine.administration.es.business;

public interface ServicesFactory {
	BillboardService createBillboardService();
	SaleService createSaleService();
	UserService createUserService();
	
}
