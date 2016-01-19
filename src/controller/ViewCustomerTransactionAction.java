package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databean.CustomerBean;
import databean.TransactionBean;
import formbean.ViewCustomerTransactionForm;
import model.CustomerDAO;
import model.Model;
import model.TransactionDAO;

public class ViewCustomerTransactionAction extends Action {
    private FormBeanFactory<ViewCustomerTransactionForm> formBeanFactory = FormBeanFactory.getInstance(ViewCustomerTransactionForm.class);
    private TransactionDAO transactionDAO;
    private CustomerDAO customerDAO;
    
    public ViewCustomerTransactionAction(Model model) {
        transactionDAO = model.getTransactionDAO();
        customerDAO = model.getCustomerDAO();
    }

    @Override
    public String getName() {
        return "ViewCustomerTransaction.do";
    }

    @Override
    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        HttpSession session = request.getSession();
        try {
            ViewCustomerTransactionForm form = formBeanFactory.create(request);
            if (!form.isPresent() || errors.size() != 0) {
                return "viewCustomerTransaction.jsp";
            }
            
            if (session.getAttribute("user") == null) {
                return "login.do";
            }

            CustomerBean[] customers = customerDAO.match(MatchArg.and(MatchArg.equals("customerId", form.getCustomerId())));
            CustomerBean customer = customers[0];
            TransactionBean[] arr;

            arr = transactionDAO.match(MatchArg.and(MatchArg.equals("customerId", customer.getCustomerId())));

            if (arr == null) {
                errors.add("No transaction history to be viewed");
                return "failure-employee.jsp";
            } else {
                return "transactionHistory_Employee.jsp";
            }
        } catch (RollbackException e) {
            errors.add("System roll back");
            return "error.jsp";
        } catch (FormBeanException e1) {
            errors.add("Form data wrong");
            return "viewCustomerTransaction.jsp";
        }
    }
}
