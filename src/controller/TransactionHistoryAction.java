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
                HttpSession session = request.getSession();
                List<String> errors = new ArrayList<String>();
                request.setAttribute("errors", errors);

                try {
                        if (session.getAttribute("user") != null && session.getAttribute("user") instanceof CustomerBean) {
                                CustomerBean user = (CustomerBean) request.getSession().getAttribute("user");

                                int customer_Id = user.getCustomerId();
                                
                                System.out.println("wawawa0");
                                
                                String sql = "select transaction.executeDate as executeDate, transaction.transactionType as transactionType, "
                                                + "transaction.fundId as fundId, transaction.shares as shares, fund_price_history.price as sharePrice, transaction.amount as amount," 
                                                + "transaction.customerId as customerId, transaction.transactionId as transactionId" 
                                                + "from transaction, fund_price_history where transaction.customerId=?";
                                
                                System.out.println("wawawa1");
                                
                                TransactionShareBean[] transactionShares = transactionShareDAO.executeQuery(sql, customer_Id);
        
                                System.out.println("wawawa2");
                                
                                if (transactionShares == null) {
                                        System.out.println("wawawa3");
                                        errors.add("No transaction history to be viewed");
                                        request.setAttribute("customer", user);
                                        return "transactionHistory_Customer.jsp";
                                } else {
                                        request.setAttribute("customer", user);
                                        request.setAttribute("transactions", transactionShares);
                                        return "transactionHistory_Customer.jsp";
                                }
                        } else {
                                return "login.do";
                        }                  
                } catch (RollbackException e) {
                        errors.add("System roll back!");
                        return "transactionHistory_Customer.jsp";
                } catch (Exception e2) {
                        errors.add("Other errors!");
                        e2.printStackTrace();
                        return "transactionHistory_Customer.jsp";
                }
        }
}
