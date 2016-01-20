package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class ViewCustomerTransactionForm extends FormBean {
    private String firstName;
    private String lastName;
    private int customerId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = sanitize(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = sanitize(lastName);
    }

    public int getCustomerId() {
        return customerId;
    }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (errors.size() > 0)
            return errors;
        
        return errors;
    }
    
    private String sanitize (String s) {
            return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;");
    }
}
