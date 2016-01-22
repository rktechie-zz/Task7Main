package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.CustomerDAO;
import model.FundDAO;
import model.FundPriceHistoryDAO;
import model.Model;
import model.PositionDAO;
import model.TransactionDAO;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databean.CustomerBean;
import databean.FundBean;
import databean.FundPriceHistoryBean;
import databean.TransactionBean;
import formbean.CreateFundForm;
import formbean.SellFundForm;

public class SellFundAction extends Action{
	private FormBeanFactory<SellFundForm> formBeanFactory = FormBeanFactory
			.getInstance(SellFundForm.class);

	private TransactionDAO transactionDAO;
	private FundDAO fundDAO;
	private CustomerDAO customerDAO;
	private FundPriceHistoryDAO fundPriceHistoryDAO;
	private PositionDAO positionDAO;

	public SellFundAction(Model model) {
		transactionDAO = model.getTransactionDAO();
		fundDAO = model.getFundDAO();
		customerDAO = model.getCustomerDAO();
		fundPriceHistoryDAO = model.getFundPriceHistoryDAO();
		positionDAO = model.getPositionDAO();
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
			SellFundForm transanctionForm = formBeanFactory.create(request);
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
			String userName = customerBean.getUserName();
			int customerId = customerBean.getCustomerId();
			long curCash = customerBean.getCash();
			
			//Get the fund ID of the fund name in form
			FundBean fundBean = fundDAO.read(transanctionForm.getName());
			int fundId = fundBean.getFundId();
			// How to determine whether this customer own this fund or not
			if (positionDAO.read(customerId, fundId)==null) {
				errors.add("You do not own this fund!");
				return "transaction.jsp";
			}
			
			//Get the price of this fund of the latest day
			FundPriceHistoryBean priceBean = fundPriceHistoryDAO.getLatestFundPrice(fundId);
			if (priceBean == null) {
				errors.add("Fund doesn't exist");
				return "transaction.jsp";
			}
			Long latestPrice = priceBean.getPrice() / 100;
			
			//Calculate shares
			Long shares = Long.parseLong(transanctionForm.getShares());
			Long amount = shares * latestPrice * 100;
			
			//Create a transaction bean
			TransactionBean transactionBean = new TransactionBean();
			transactionBean.setCustomerId(customerId);
			transactionBean.setUserName(userName);
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
