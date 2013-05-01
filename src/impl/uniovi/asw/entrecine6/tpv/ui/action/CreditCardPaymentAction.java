package impl.uniovi.asw.entrecine6.tpv.ui.action;

import impl.uniovi.asw.entrecine6.tpv.TPVActions;
import es.uniovi.asw.entrecine6.tpv.model.CreditCardSale;
import es.uniovi.asw.entrecine6.tpv.model.PaymentResult;
import es.uniovi.asw.entrecine6.tpv.model.Session;
import es.uniovi.asw.entrecine6.tpv.util.BusinessException;
import es.uniovi.asw.entrecine6.tpv.util.console.Console;
import es.uniovi.asw.entrecine6.tpv.util.menu.Action;

public class CreditCardPaymentAction implements Action {

	@Override
	public void execute() throws BusinessException {
		// Muestra la cartelera antes de comprar
		RequestBillboardAction rba = new RequestBillboardAction();
		rba.execute();
		
		// Hace la compra
		CreditCardSale sale = new CreditCardSale(Console.readLong("ID"),
				Console.readInt("Número de asientos"), 
				new Session(
						Console.readLong("ID"), 
						Console.readLong("Pelicula"),
						Console.readInt("Sala"),
						Console.readString("Fecha"),
						(float) Console.readFloat("Hora"),
						(float) Console.readFloat("Precio")),
				Console.readString("Numero de tarjeta"));
		
		// La manda al sistema centra
		TPVActions tpva = new TPVActions();

		PaymentResult ps = tpva.cashPayment(sale);
		
		// Muestra el resultado
		if (ps != null)
			System.out.println(ps.toString());
		else
			System.err.println("Ha ocurrido un error en la venta");
	}
}
