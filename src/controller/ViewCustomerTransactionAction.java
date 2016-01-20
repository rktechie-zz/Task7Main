package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databean.TransactionShareBean;
import formbean.ViewCustomerTransactionForm;
import model.Model;
import model.TransactionShareDAO;

public class ViewCustomerTransactionAction extends Action {
        private FormBeanFactory<ViewCustomerTransactionForm> formBeanFactory = FormBeanFactory
                        .getInstance(ViewCustomerTransactionForm.class);
        private TransactionShareDAO transactionShareDAO;

        public ViewCustomerTransactionAction(Model model) {
                transactionShareDAO = model.getTransactionShareDAO();
        }

        @Override
        public String getName() {
                return "viewCustomerTransaction.do";
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

                        int customer_Id = form.getCustomerId();

                        String sql = "select executeDate as executeDate, transactionType as transactionType, "
                                        + "fundId as fundId, shares as shares, price as sharePrice, amount as amount " 
                                        + "customer_id as customer_id, transactionId as transactionId" 
                                        + "from transaction, fund_price_history where customer.id=?";
                        
                        TransactionShareBean[] transactionShares = transactionShareDAO.executeQuery(sql, customer_Id);
                        
                        request.setAttribute("transactions", transactionShares);

                        if (transactionShares  == null) {
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
