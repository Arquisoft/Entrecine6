package impl.uniovi.asw.entrecine6.central.persistence;

import java.sql.SQLException;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;

public interface Invoke {
	
	Object invoke() throws SQLException, BusinessException;

}
