package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databean.CustomerBean;
import databean.EmployeeBean;
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
                HttpSession session = request.getSession();
                List<String> errors = new ArrayList<String>();
                request.setAttribute("errors", errors);
                        
                try {
                        if (session.getAttribute("user") != null && session.getAttribute("user") instanceof EmployeeBean) {
                                ViewCustomerTransactionForm form = formBeanFactory.create(request);
                                request.setAttribute("form", form);
                                
                                if (!form.isPresent()) {
                                        return "viewCustomerTransaction.jsp";
                                }
                                
                                errors.addAll(form.getValidationErrors());
                                
                                if (errors.size() != 0) {
                                        return "viewCustomerTransaction.jsp";
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
                                        return "transactionHistory_Employee.jsp";
                                } else {
                                        request.setAttribute("transactions", transactionShares);
                                        return "transactionHistory_Employee.jsp";
                                }
                        } else {
                                return "login.do";
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
