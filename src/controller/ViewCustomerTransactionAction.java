package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databean.CustomerBean;
import databean.TransactionShareBean;
import formbean.ViewCustomerTransactionForm;
import model.CustomerDAO;
import model.Model;
import model.TransactionShareDAO;

public class ViewCustomerTransactionAction extends Action {
        private FormBeanFactory<ViewCustomerTransactionForm> formBeanFactory = FormBeanFactory
                        .getInstance(ViewCustomerTransactionForm.class);
        private TransactionShareDAO transactionShareDAO;
        private CustomerDAO customerDAO;

        public ViewCustomerTransactionAction(Model model) {
                transactionShareDAO = model.getTransactionShareDAO();
                customerDAO = model.getCustomerDAO();
        }

        @Override
        public String getName() {
                return "viewCustomerTransaction.do";
        }

        @Override
        public String perform(HttpServletRequest request) {
                List<String> errors = new ArrayList<String>();
                request.setAttribute("errors", errors);
                        
                try {         
                        HttpSession session = request.getSession();
                        ViewCustomerTransactionForm form = formBeanFactory.create(request);
                        request.setAttribute("form", form);
                        
                        if (!form.isPresent()) {
                                return "viewCustomerTransaction.jsp";
                        }
                        
                        if (errors.size() != 0) {
                                errors.add("Errors appear!");
                                return "viewCustomerTransaction.jsp";
                        }

                        if (session.getAttribute("user") == null) {
                                errors.add("User not log in.");
                                return "login.do";
                        }
                        CustomerBean customer = customerDAO.read(form.getUserName());
                        
                        if (customer == null) {
                                errors.add("Customer does not exist.");
                                return "viewCustomerTransaction.jsp";
                        }
                        
                        String sql = "select transaction.executeDate as executeDate, transaction.transactionType as transactionType, "
                                        + "transaction.fundId as fundId, transaction.shares as shares, fund_price_history.price as sharePrice, transaction.amount as amount," 
                                        + "transaction.customerId as customerId, transaction.transactionId as transactionId" 
                                        + "from transaction, fund_price_history where transaction.customerId=?";
                        
                        TransactionShareBean[] transactionShares = transactionShareDAO.executeQuery(sql, customer.getCustomerId());
                        
                        if (transactionShares  == null) {
                                errors.add("No transaction history to be viewed");
                                return "failure-employee.jsp";
                        } else {
                                request.setAttribute("transactions", transactionShares);
                                return "transactionHistory_Employee.jsp";
                        }
                } catch (RollbackException e) {
                        errors.add("System roll back!");
                        return "viewCustomerTransaction.jsp";
                } catch (FormBeanException e1) {
                        errors.add("Form data wrong!");
                        return "viewCustomerTransaction.jsp";
                } catch (Exception e2) {
                        errors.add("Other errors!");
                        e2.printStackTrace();
                        return "viewCustomerTransaction.jsp";
                }
        }
}
