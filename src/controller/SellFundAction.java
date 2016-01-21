package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.CustomerDAO;
import model.FundDAO;
import model.FundPriceHistoryDAO;
import model.Model;
import model.TransactionDAO;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databean.CustomerBean;
import databean.FundBean;
import databean.FundPriceHistoryBean;
import databean.TransactionBean;
import formbean.CreateFundForm;
import formbean.TransactionForm;

public class SellFundAction extends Action{
	private FormBeanFactory<TransactionForm> formBeanFactory = FormBeanFactory
			.getInstance(TransactionForm.class);

	private TransactionDAO transactionDAO;
	private FundDAO fundDAO;
	private CustomerDAO cumtomerDAO;
	private FundPriceHistoryDAO fundPriceHistoryDAO;

	public SellFundAction(Model model) {
		transactionDAO = model.getTransactionDAO();
		fundDAO = model.getFundDAO();
		cumtomerDAO = model.getCustomerDAO();
		fundPriceHistoryDAO = model.getFundPriceHistoryDAO();
	}

	@Override
	public String getName() {
		return "buyFund.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		HttpSession session = request.getSession();

		try {
			TransactionForm transanctionForm = formBeanFactory.create(request);
			request.setAttribute("form", transanctionForm);

			if (session.getAttribute("user") == null) {
				return "login.do";
			}

			if (!transanctionForm.isPresent()) {
				return "transaction.jsp";
			}

			errors.addAll(transanctionForm.getValidationErrors());
			if (errors.size() != 0) {
				return "transaction.jsp";
			}
			
			//Current customer and the customer ID
			CustomerBean customerBean = (CustomerBean) session.getAttribute("user");
			int customerId = customerBean.getCustomerId();
			long curCash = customerBean.getCash();
			
			//Get the fund ID of the fund name in form
			FundBean fundBean = fundDAO.read(transanctionForm.getName());
			int fundId = fundBean.getFundId();
			
			//Get the price of this fund of the latest day
			FundPriceHistoryBean priceBean = fundPriceHistoryDAO.getLatestFundPrice(fundId);
			Long latestPrice = priceBean.getPrice();
			
			//Calculate shares
			Long shares = Long.parseLong(transanctionForm.getShares());
			Long amount = shares * latestPrice;
			
			//Create a transaction bean
			TransactionBean transactionBean = new TransactionBean();
			transactionBean.setCustomerId(customerId);
			transactionBean.setUserName(customerBean.getUserName());
			transactionBean.setAmount(amount);
			transactionBean.setShares(shares);
			transactionBean.setTransactionType("4");
			
			transactionDAO.create(transactionBean);
			return "success-customer.jsp";
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "createFund.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "createFund.jsp";
		}
	}

}
