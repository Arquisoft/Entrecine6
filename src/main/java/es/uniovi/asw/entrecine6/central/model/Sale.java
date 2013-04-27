package es.uniovi.asw.entrecine6.central.model;

import java.io.Serializable;

public interface Sale extends Serializable{
	
	Long getId();
	
	int getNumberOfSeats();
	
	Session getSession();	
	
	String getPaymentInfo();

}
