package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class SellFundForm extends FormBean{
	private String 	name;
	private String 	amount;
	private String 	shares;
	
	public String getName() {
		return name;
	}

	public String getAmount() {
		return amount;
	}

	public String getShares() {
		return shares;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public void setShares(String shares) {
		this.shares = shares;
	}

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (name == null || name.trim().length() == 0)
			errors.add("Fund name is required");
//		if (!amount.matches(".*\\d.*")) 
//			errors.add("Ammount should be numeric");
		if (!shares.matches(".*\\d.*"))
			errors.add("Shares should be numeric");
//		if (Long.parseLong(amount) < 0)
//			errors.add("Amount should not be negetive");
		if (Long.parseLong(shares) < 0)
			errors.add("Shares should not be negetive");
		
		if (errors.size() > 0)
			return errors;
		
		return errors;
	}
	
	private String sanitize(String s) {
		return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;");
	}
}
