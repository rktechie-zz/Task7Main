package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class RequestCheckForm extends FormBean {
	private String requestAmount;
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public boolean isPresent() {
		return action != null;
	}
	

	public String getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(String requestAmount) {
		this.requestAmount = requestAmount;
	}

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		try {
			Long.parseLong(requestAmount);
		} catch (NumberFormatException e1) {
			errors.add("Amount should be an Integer");
			return errors;
		}

		if (Long.parseLong(requestAmount) <= 0) {
			errors.add("The amount of request should be a positive");
		}

		if (errors.size() > 0)
			return errors;

		return errors;
	}

}
