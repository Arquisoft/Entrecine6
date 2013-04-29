package main.java.es.uniovi.asw.entrecine.administration.LogicManager.business;

import main.java.es.uniovi.asw.entrecine.administration.es.business.BillBoardCommitService;
import main.java.es.uniovi.asw.entrecine.administration.es.business.ServicesCommitFactory;

public class CommitManager implements ServicesCommitFactory {

	@Override
	public BillBoardCommitService createBoardCommitService() {
		// TODO Auto-generated method stub
		return new SimpleBillboardCommitService();
	}

}
