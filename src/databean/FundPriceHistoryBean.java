package databean;

import org.genericdao.PrimaryKey;

@PrimaryKey("fundId,priceDate")
public class FundPriceHistoryBean {
	private int fundId;
	private String priceDate;
	private long price;

	public void setFundId(int v) {
		fundId = v;
	}

	public void setPriceDate(String v) {
		priceDate = v;
	}

	public void setPrice(long v) {
		price = v;
	}

	public int getFundId() {
		return fundId;
	}

	public String getPriceDate() {
		return priceDate;
	}

	public long getPrice() {
		return price;
	}
}
