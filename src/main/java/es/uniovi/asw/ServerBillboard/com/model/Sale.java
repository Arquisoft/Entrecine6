package main.java.es.uniovi.asw.ServerBillboard.com.model;

public interface Sale {
	
	Long getId();
	
	int getNumberOfSeats();
	
	Session getSession();	
	
	String getPaymentInfo();

}
