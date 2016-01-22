package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class ViewCustomerTransactionForm extends FormBean {
        private String userName;

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = sanitize(userName);
        }

        public List<String> getValidationErrors() {
                List<String> errors = new ArrayList<String>();
                
                if (userName == null || userName.trim().length() == 0)
                        errors.add("User name is required.");

                if (errors.size() > 0)
                        return errors;

                return errors;
        }

        private String sanitize(String s) {
                return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;");
        }
}
