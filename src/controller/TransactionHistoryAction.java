package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databean.CustomerBean;
import databean.FundPriceHistoryBean;
import databean.TransactionBean;
import databean.TransactionShareBean;
import model.FundPriceHistoryDAO;
import model.Model;
import model.TransactionDAO;

public class TransactionHistoryAction extends Action {
        private TransactionDAO transactionDAO;
        private FundPriceHistoryDAO fundPriceHistoryDAO;

        public TransactionHistoryAction(Model model) {
                transactionDAO = model.getTransactionDAO();
                fundPriceHistoryDAO = model.getFundPriceHistoryDAO();
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
                        if (session.getAttribute("user") != null
                                        && session.getAttribute("user") instanceof CustomerBean) {
                                CustomerBean user = (CustomerBean) request.getSession().getAttribute("user");

                                int customer_Id = user.getCustomerId();

                                List<TransactionShareBean> transactionShares = new ArrayList<TransactionShareBean>();
                                TransactionBean[] transactions = transactionDAO
                                                .match(MatchArg.equals("customerId", customer_Id));
                                for (TransactionBean t : transactions) {
                                        TransactionShareBean tShare = new TransactionShareBean();

                                        tShare.setTransactionId(t.getTransactionId());
                                        tShare.setTransactionType(t.getTransactionType());
                                        tShare.setCustomeId(t.getCustomerId());

                                        if (t.getFundId() == 0) {
                                                tShare.setAmount(t.getAmount());
                                                tShare.setFundId(-1);
                                                tShare.setShares(-1);
                                                tShare.setSharePrice(-1);
                                                if (t.getExecuteDate() != null) {
                                                        tShare.setExecuteDate(t.getExecuteDate());
                                                } else {
                                                        tShare.setExecuteDate("N/A");
                                                }
                                        } else {
                                                tShare.setFundId(t.getFundId());
                                                int fund_Id = tShare.getFundId();
                                                FundPriceHistoryBean f = fundPriceHistoryDAO
                                                                .getLatestFundPrice(fund_Id);
                                                tShare.setSharePrice(f.getPrice() / 100);

                                                if (t.getTransactionId() == 8) {
                                                        if (t.getExecuteDate() == null ) {
                                                                tShare.setExecuteDate("N/A");
                                                                tShare.setShares(-1);
                                                        } else {
                                                                tShare.setExecuteDate(t.getExecuteDate());
                                                                tShare.setShares(t.getShares() / 1000);       
                                                        }
                                                        tShare.setAmount(t.getAmount() / 100);
                                                }
                                                
                                                if (t.getTransactionId() == 4) {
                                                        if (t.getExecuteDate() == null ) {
                                                                tShare.setExecuteDate("N/A");
                                                                tShare.setAmount(-1);
                                                        } else {
                                                                tShare.setExecuteDate(t.getExecuteDate());
                                                                tShare.setAmount(t.getAmount() / 100);                                                     
                                                        }
                                                        tShare.setShares(t.getShares() / 1000);
                                                }
                                        }
                                        transactionShares.add(tShare);
                                }

                                if (transactionShares.size() == 0) {
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
                        e.printStackTrace();
                        return "transactionHistory_Customer.jsp";
                } catch (Exception e2) {
                        errors.add("Other errors!");
                        e2.printStackTrace();
                        return "transactionHistory_Customer.jsp";
                }
        }
}
