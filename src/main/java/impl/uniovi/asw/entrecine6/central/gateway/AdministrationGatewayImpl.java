package impl.uniovi.asw.entrecine6.central.gateway;

import java.util.List;

import javax.sql.rowset.CachedRowSet;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.gateway.AdministrationGateway;
import es.uniovi.asw.entrecine6.central.infrastructure.DBServicesFactory;
import es.uniovi.asw.entrecine6.central.model.Sale;
import es.uniovi.asw.entrecine6.central.model.User;
import es.uniovi.asw.entrecine6.central.persistence.BillboardDBService;
import es.uniovi.asw.entrecine6.central.persistence.SalesDBService;
import es.uniovi.asw.entrecine6.central.persistence.UserDBService;

public class AdministrationGatewayImpl implements AdministrationGateway {

	@Override
	public List<User> getUsers() throws BusinessException {
		UserDBService service = DBServicesFactory.getUserDBService();
		try {
			return service.findAll();
		} catch (BusinessException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Sale> getSales() throws BusinessException {
		SalesDBService service = DBServicesFactory.getSalesDBService();
		try {
			return service.findAll();
		} catch (BusinessException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public CachedRowSet getBillboard() throws BusinessException {
		BillboardDBService service = DBServicesFactory.getBillboardDBService();
		try {
			return service.getRawBillboard();
		} catch (BusinessException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void updateBillboard(CachedRowSet billboard)
			throws BusinessException {
		BillboardDBService service = DBServicesFactory.getBillboardDBService();
		try {
			service.updateBilboard(billboard);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw e;
		}
	}

}
