package impl.uniovi.asw.entrecine6.tpv.ui;

import impl.uniovi.asw.entrecine6.tpv.ui.action.CashPaymentAction;
import impl.uniovi.asw.entrecine6.tpv.ui.action.CreditCardPaymentAction;
import es.uniovi.asw.entrecine6.tpv.util.menu.BaseMenu;

public class SalesMenu extends BaseMenu {

	public SalesMenu() {
		menuOptions = new Object[][] { { "TPV Virtual > Ventas", null },
				{ "Pago en efectivo", CashPaymentAction.class },
				{ "Pago con tarjeta", CreditCardPaymentAction.class } };
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}
}
