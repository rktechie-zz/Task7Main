package databean;

import org.genericdao.PrimaryKey;

@PrimaryKey("fundId,executeDate")
public class FundPriceHistoryBean {
	private int fundId;
	private String executeDate;

	public String getExecuteDate() {
		return executeDate;
	}

	public void setExecuteDate(String executeDate) {
		this.executeDate = executeDate;
	}

	public int getFundId() {
		return fundId;
	}

	public void setFundId(int fundId) {
		this.fundId = fundId;
	}
	


	
}
