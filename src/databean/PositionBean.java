package databean;

import org.genericdao.PrimaryKey;

@PrimaryKey("customerId,fundId")
public class PositionBean {
	private String customerId;
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	private int fundId;
	private long shares;

	public void setFundId(int v) {
		fundId = v;
	}

	public void setShares(long v) {
		shares = v;
	}



	public int getFundId() {
		return fundId;
	}

	public long getShares() {
		return shares;
	}
}
