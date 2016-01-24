package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databean.CustomerBean;
import databean.FundBean;
import databean.FundPriceHistoryBean;
import databean.TransactionBean;
import formbean.BuyFundForm;
import model.FundDAO;
import model.FundPriceHistoryDAO;
import model.Model;
import model.TransactionDAO;

public class BuyFundAction extends Action{
	private FormBeanFactory<BuyFundForm> formBeanFactory = FormBeanFactory
			.getInstance(BuyFundForm.class);

	private TransactionDAO transactionDAO;
	private FundDAO fundDAO;
	private FundPriceHistoryDAO fundPriceHistoryDAO;

	public BuyFundAction(Model model) {
		transactionDAO = model.getTransactionDAO();
		fundDAO = model.getFundDAO();
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
			BuyFundForm buyFundForm = formBeanFactory.create(request);
			request.setAttribute("form", buyFundForm);

			if (session.getAttribute("user") == null) {
				return "login.do";
			}

			if (!buyFundForm.isPresent()) {
				return "buyFund.jsp";
			}

			errors.addAll(buyFundForm.getValidationErrors());
			if (errors.size() != 0) {
				return "buyFund.jsp";
			}
			
			//Current customer and the customer ID
			CustomerBean customerBean = (CustomerBean) session.getAttribute("user");
			String userName = customerBean.getUserName();
			int customerId = customerBean.getCustomerId();
			long curCash = customerBean.getCash() / 100;
			
			//Get the fund ID of the fund name in form
			FundBean fundBean = fundDAO.read(buyFundForm.getName());
			if (fundBean == null) {
				errors.add("Fund does not exist");
				return "buyFund.jsp";
			}
			int fundId = fundBean.getFundId();

			//Get the price of this fund of the latest day
			FundPriceHistoryBean priceBean = fundPriceHistoryDAO.getLatestFundPrice(fundId);
			if (priceBean == null) {
				errors.add("This fund does not have price yet, not able to buy");
				return "buyFund.jsp";
			}
			Double latestPrice = (double) priceBean.getPrice() / 100;
			
			//Calculate shares
			Long amount = (long) (Double.parseDouble(buyFundForm.getAmount()));
//			System.out.println("Current Cash:" + curCash);
//			System.out.println("User Name:" + userName);
//			System.out.println("Amount value:" + amount);
			//Check valid balance
			Long validBalance = (long) transactionDAO.getValidBalance(userName, curCash);
			if (amount > validBalance) {
				errors.add("You do not have enough money!");
				return "buyFund.jsp";
			}
			Double shares = (double) (amount / latestPrice);

			//Create a transaction bean
			TransactionBean transactionBean = new TransactionBean();
			transactionBean.setCustomerId(customerId);
			transactionBean.setFundId(fundId);
			transactionBean.setUserName(customerBean.getUserName());
			transactionBean.setAmount(amount * 100l);
			transactionBean.setShares((long)(shares * 1000));
			transactionBean.setTransactionType("8");
			transactionDAO.create(transactionBean);

			return "success-customer.jsp";
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "buyFund.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "buyFund.jsp";
		}
	}
}
