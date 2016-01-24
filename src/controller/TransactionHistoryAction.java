package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import databean.CustomerBean;
import databean.TransactionShareBean;
import model.Model;
import model.TransactionShareDAO;

public class TransactionHistoryAction extends Action {
        private TransactionShareDAO transactionShareDAO;

        public TransactionHistoryAction(Model model) {
                transactionShareDAO = model.getTransactionShareDAO();
        }

        @Override
        public String getName() {
                return "transactionHistory.do";
        }

        @Override
        public String perform(HttpServletRequest request) {
                List<String> errors = new ArrayList<String>();
                request.setAttribute("errors", errors);

                try {
                        CustomerBean user = (CustomerBean) request.getSession().getAttribute("user");
                        
                        if (errors.size() != 0) {
                                errors.add("Errors appear!");
                                return "customerHome.jsp";
                        }
                        
                        if (user == null) {
                                errors.add("User not log in.");
                                return "login.do";
                        }

                        int customer_Id = user.getCustomerId();
                        
                        String sql = "select transaction.executeDate as executeDate, transaction.transactionType as transactionType, "
                                        + "transaction.fundId as fundId, transaction.shares as shares, fund_price_history.price as sharePrice, transaction.amount as amount," 
                                        + "transaction.customerId as customerId, transaction.transactionId as transactionId" 
                                        + "from transaction, fund_price_history where transaction.customerId=?";
                        
                        TransactionShareBean[] transactionShares = transactionShareDAO.executeQuery(sql, customer_Id);

                        if (transactionShares == null) {
                                errors.add("No transaction history to be viewed");
                                return "failure-customer.jsp";
                        } else {
                                request.setAttribute("customer", user);
                                request.setAttribute("transactions", transactionShares);
                                return "transactionHistory_Customer.jsp";
                        }
                } catch (RollbackException e) {
                        errors.add("System roll back!");
                        return "customerHome.jsp";
                } catch (Exception e2) {
                        errors.add("Other errors!");
                        e2.printStackTrace();
                        return "customerHome.jsp";
                }
        }
}
