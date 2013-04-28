package impl.uniovi.asw.entrecine6.central.gateway;

import es.uniovi.asw.entrecine6.central.business.BillboardService;
import es.uniovi.asw.entrecine6.central.business.PaymentService;
import es.uniovi.asw.entrecine6.central.business.UsersService;
import es.uniovi.asw.entrecine6.central.business.listener.BillboardUpdateListener;
import es.uniovi.asw.entrecine6.central.gateway.WebServerGateway;
import es.uniovi.asw.entrecine6.central.infrastructure.ServicesFactory;
import es.uniovi.asw.entrecine6.central.model.Billboard;
import es.uniovi.asw.entrecine6.central.model.PaymentResult;
import es.uniovi.asw.entrecine6.central.model.Sale;
import es.uniovi.asw.entrecine6.central.model.Ticket;
import es.uniovi.asw.entrecine6.central.model.User;

public class WebServerGatewayImpl implements WebServerGateway {

	public WebServerGatewayImpl() {
	}

	@Override
	public boolean register(User user) {
		UsersService service = ServicesFactory.getUsersService();
		return service.saveUser(user);
	}

	@Override
	public User login(String userName, String password) {
		UsersService service = ServicesFactory.getUsersService();
		return service.loadUser(userName, password);
	}

	@Override
	public Billboard requestBillboard() {
		BillboardService service = ServicesFactory.getBillboardService();
		return service.getServerBillboard();
	}

	@Override
	public PaymentResult payment(Sale sale) {
		PaymentService service = ServicesFactory.getPaymentService();
		return service.serverPayment(sale);
	}

	@Override
	public Ticket receiveTicket(Sale sale) {
		PaymentService service = ServicesFactory.getPaymentService();
		return service.obtainTicket(sale);
	}

	@Override
	public void connect(BillboardUpdateListener listener) {
		BillboardService service = ServicesFactory.getBillboardService();
		service.connectBillboard(listener);
	}

}
