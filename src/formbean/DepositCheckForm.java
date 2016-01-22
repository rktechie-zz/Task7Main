package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class DepositCheckForm extends FormBean {
	private String userName;
	private String depositAmount;
	private String action;



	public String getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(String depositAmount) {
		this.depositAmount = depositAmount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public boolean isPresent() {
		return action != null;
	}

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		System.out.println(userName);
		System.out.println(depositAmount);
		
		try {
			Double.parseDouble(depositAmount);
		} catch (NumberFormatException e1) {
			errors.add("Neither the amount is a number or the amount is too large");
			return errors;
		}

		if (Long.parseLong(depositAmount) <= 0) {
			errors.add("The amount of request should be positive");
		}

		if (errors.size() > 0)
			return errors;

		return errors;
	}

}
