package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class CreateFundForm extends FormBean{
	private int 	fundId;
	private String 	name;
	
	public int getFundId() {
		return fundId;
	}
	public String getName() {
		return name;
	}
	public void setFundId(int fundId) {
		this.fundId = fundId;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (name == null || name.trim().length() == 0)
			errors.add("Fund name is required");
		if (String.valueOf(fundId) == null || String.valueOf(fundId).length() < 1
				|| String.valueOf(fundId).length() >5)
			errors.add("The length of fundId should be between 1~5");

		if (errors.size() > 0)
			return errors;
		
		return errors;
	}
}
