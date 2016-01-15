package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class RequestCheckForm extends FormBean {
	private String amount;
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public boolean isPresent() {
		return action != null;
	}

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		try {
			Integer.parseInt(amount);
		} catch (NumberFormatException e1) {
			errors.add("Amount should be an Integer");
			return errors;
		}

		if (Integer.parseInt(amount) <= 0) {
			errors.add("The amount of request should be a positive");
		}

		if (errors.size() > 0)
			return errors;

		return errors;
	}

}
