package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databean.CustomerBean;
import databean.TransactionBean;
import model.Model;
import model.TransactionDAO;

public class TransactionHistoryAction extends Action {
        private TransactionDAO transactionDAO;

        public TransactionHistoryAction(Model model) {
                transactionDAO = model.getTransactionDAO();
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

                        CustomerBean user = (CustomerBean) request.getSession().getAttribute("user");
                        TransactionBean[] arr;

                        arr = transactionDAO.match(MatchArg.and(MatchArg.equals("customerId", user.getCustomerId())));

                        if (arr == null) {
                                errors.add("No transaction history to be viewed");
                                return "failure-customer.jsp";
                        } else {
                                return "TransactionHistory.jsp";
                        }
                } catch (RollbackException e) {
                        errors.add("System roll back");
                        return "error.jsp";
                }
        }
}
