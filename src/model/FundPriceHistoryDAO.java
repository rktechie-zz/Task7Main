package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databean.FundPriceHistoryBean;

public class FundPriceHistoryDAO extends GenericDAO<FundPriceHistoryBean> {
	public FundPriceHistoryDAO(ConnectionPool cp, String tableName)
			throws DAOException {
		super(FundPriceHistoryBean.class, tableName, cp);
	}
	
	public FundPriceHistoryBean getLatestFundPrice(int fundId) throws RollbackException{
		FundPriceHistoryBean[] fundPriceHistory = match(MatchArg.equals("fundId", fundId));
		if(fundPriceHistory.length == 0) return null;
		return fundPriceHistory[fundPriceHistory.length-1];
	}
}
