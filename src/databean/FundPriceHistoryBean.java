package databean;

import org.genericdao.PrimaryKey;

@PrimaryKey("fundId,executeDate")
public class FundPriceHistoryBean {
	private int fundId;
	private String executeDate;
	private long price;

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

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
