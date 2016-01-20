package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class ViewCustomerTransactionForm extends FormBean {
    private String firstName;
    private String lastName;
    private int customerId = Integer.MIN_VALUE;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (firstName == null || firstName.trim().length() == 0)
            errors.add("Customer first name is required");
        if (lastName == null || lastName.trim().length() == 0)
            errors.add("Customer last name is required");
        if (customerId == Integer.MIN_VALUE)
            errors.add("Customer Id is required");

        if (errors.size() > 0)
            return errors;
        
        return errors;
    }
}
