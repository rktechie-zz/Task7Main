package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
                HttpSession session = request.getSession();

                try {
                        if (session.getAttribute("user") == null) {
                                return "login.do";
                        }

                        CustomerBean customer = (CustomerBean) request .getAttribute("user");
                        int customer_Id = customer.getCustomerId();
                        
                        String sql = "select executeDate as executeDate, transactionType as transactionType, "
                                        + "fundId as fundId, shares as shares, price as sharePrice, amount as amount " 
                                        + "customer_id as customer_id, transactionId as transactionId" 
                                        + "from transaction, fund_price_history where customer_id=?";
                        
                        TransactionShareBean[] transactionShares = transactionShareDAO.executeQuery(sql, customer_Id);

                        request.setAttribute("customer", customer);
                        request.setAttribute("transactions", transactionShares);

                        if (transactionShares == null) {
                                errors.add("No transaction history to be viewed");
                                return "failure-customer.jsp";
                        } else {
                                return "transactionHistory_Customer.jsp";
                        }
                } catch (RollbackException e) {
                        errors.add("System roll back");
                        return "error.jsp";
                }
        }
}
