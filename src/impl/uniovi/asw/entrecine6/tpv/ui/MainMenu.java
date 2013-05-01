package impl.uniovi.asw.entrecine6.tpv.ui;

import impl.uniovi.asw.entrecine6.tpv.ui.action.CheckTicketAction;
import impl.uniovi.asw.entrecine6.tpv.ui.action.RequestBillboardAction;
import es.uniovi.asw.entrecine6.tpv.util.menu.BaseMenu;

public class MainMenu extends BaseMenu {

	public MainMenu() {
		menuOptions = new Object[][] { { "TPV Virtual", null },
				{ "Mostrar Cartelera", RequestBillboardAction.class },
				{ "Comprobar Ticket", CheckTicketAction.class },
				{ "Realizar Pago", SalesMenu.class } };
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}

}
