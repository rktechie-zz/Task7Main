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
import databean.PositionBean;
import databean.TransactionBean;
import formbean.CreateFundForm;
import formbean.SellFundForm;

public class SellFundAction extends Action{
	private FormBeanFactory<SellFundForm> formBeanFactory = FormBeanFactory
			.getInstance(SellFundForm.class);

	private TransactionDAO transactionDAO;
	private FundDAO fundDAO;
	private FundPriceHistoryDAO fundPriceHistoryDAO;
	private PositionDAO positionDAO;

	public SellFundAction(Model model) {
		transactionDAO = model.getTransactionDAO();
		fundDAO = model.getFundDAO();
		fundPriceHistoryDAO = model.getFundPriceHistoryDAO();
		positionDAO = model.getPositionDAO();
	}

	@Override
	public String getName() {
		return "sellFund.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		HttpSession session = request.getSession();

		try {
			SellFundForm sellFundForm = formBeanFactory.create(request);
			request.setAttribute("form", sellFundForm);

			if (session.getAttribute("user") == null) {
				return "login.do";
			}

			if (!sellFundForm.isPresent()) {
				return "sellFund.jsp";
			}

			errors.addAll(sellFundForm.getValidationErrors());
			if (errors.size() != 0) {
				return "sellFund.jsp";
			}
			
			//Current customer and the customer ID
			CustomerBean customerBean = (CustomerBean) session.getAttribute("user");
			String userName = customerBean.getUserName();
			int customerId = customerBean.getCustomerId();
			long curCash = customerBean.getCash() / 100;
			
			//Get the fund ID of the fund name in form
			FundBean fundBean = fundDAO.read(sellFundForm.getName());
			if (fundBean == null) {
				errors.add("Fund does not exist");
				return "buyFund.jsp";
			}
			int fundId = fundBean.getFundId();
			// How to determine whether this customer own this fund or not
			PositionBean position = positionDAO.read(customerId, fundId);
			if (position == null) {
				errors.add("You do not own this fund!");
				return "sellFund.jsp";
			}
			
			//Get the price of this fund of the latest day
			FundPriceHistoryBean priceBean = fundPriceHistoryDAO.getLatestFundPrice(fundId);
			if (priceBean == null) {
				errors.add("Fund doesn't exist");
				return "sellFund.jsp";
			}
			Long latestPrice = priceBean.getPrice() / 100;
			
			//Calculate shares
			Long shares = Long.parseLong(sellFundForm.getShares()) / 1000;
			//Determine whether customer has this many shares
			if (position.getShares() > shares) {
				errors.add("You do not have this many shares!");
				return "sellFund.jsp";
			}
			Long amount = shares * latestPrice;
			
			//Create a transaction bean
			TransactionBean transactionBean = new TransactionBean();
			transactionBean.setCustomerId(customerId);
			transactionBean.setFundId(fundId);
			transactionBean.setUserName(userName);
			transactionBean.setAmount(amount * 100);
			transactionBean.setShares(shares * 1000);
			transactionBean.setTransactionType("4");
			
			transactionDAO.create(transactionBean);
			return "success-customer.jsp";
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "sellFund.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "sellFund.jsp";
		}
	}

}
