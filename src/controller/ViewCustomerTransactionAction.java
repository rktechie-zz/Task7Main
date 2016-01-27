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
import databean.EmployeeBean;
import databean.FundPriceHistoryBean;
import databean.TransactionBean;
import databean.TransactionShareBean;
import formbean.ViewCustomerTransactionForm;
import model.CustomerDAO;
import model.FundPriceHistoryDAO;
import model.Model;
import model.TransactionDAO;

public class ViewCustomerTransactionAction extends Action {
        private FormBeanFactory<ViewCustomerTransactionForm> formBeanFactory = FormBeanFactory
                        .getInstance(ViewCustomerTransactionForm.class);
        private TransactionDAO transactionDAO;
        private CustomerDAO customerDAO;
        private FundPriceHistoryDAO fundPriceHistoryDAO;

        public ViewCustomerTransactionAction(Model model) {
                transactionDAO = model.getTransactionDAO();
                customerDAO = model.getCustomerDAO();
                fundPriceHistoryDAO = model.getFundPriceHistoryDAO();
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
                                
                                int customer_Id = customer.getCustomerId();
                                
                                List<TransactionShareBean> transactionShares = new ArrayList<TransactionShareBean>();
                                TransactionBean[] transactions = transactionDAO.match(MatchArg.equals("customerId", customer_Id));
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
                                                tShare.setSharePrice(f.getPrice());

                                                if (t.getTransactionId() == 8) {
                                                        if (t.getExecuteDate() == null ) {
                                                                tShare.setExecuteDate("N/A");
                                                                tShare.setShares(-1);
                                                        } else {
                                                                tShare.setExecuteDate(t.getExecuteDate());
                                                                tShare.setShares(t.getShares());        
                                                        }
                                                        tShare.setAmount(t.getAmount());
                                                }
                                                
                                                if (t.getTransactionId() == 4) {
                                                        if (t.getExecuteDate() == null ) {
                                                                tShare.setExecuteDate("N/A");
                                                                tShare.setAmount(-1);
                                                        } else {
                                                                tShare.setExecuteDate(t.getExecuteDate());
                                                                tShare.setAmount(t.getAmount());                                                     
                                                        }
                                                        tShare.setShares(t.getShares());
                                                }
                                        }                                             
                                        transactionShares.add(tShare);
                                }
                                
                                if (transactionShares.size() == 0) {
                                        errors.add("No transaction history to be viewed");
                                        request.setAttribute("customer", customer);
                                        return "transactionHistory_Employee.jsp";
                                } else {
                                        request.setAttribute("transactions", transactionShares);
                                        request.setAttribute("customer", customer);
                                        return "transactionHistory_Employee.jsp";
                                }
                        } else {
                                return "login.do";
                        }
                } catch (RollbackException e) {
                        errors.add("System roll back!");
                        e.printStackTrace();
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
