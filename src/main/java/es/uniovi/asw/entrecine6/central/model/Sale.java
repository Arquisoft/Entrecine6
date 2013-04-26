package es.uniovi.asw.entrecine6.central.model;

public interface Sale {
	
	Long getId();
	
	int getNumberOfSeats();
	
	Session getSession();	
	
	String getPaymentInfo();

}
