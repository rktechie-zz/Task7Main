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
			
			//Get the price of this fund
			FundPriceHistoryBean priceBean = fundPriceHistoryDAO.read(fundId);
			
			
			
			TransactionBean transactionBean = new TransactionBean();
			transactionBean.setAmount(Long.parseLong(transanctionForm.getAmount()));
			transactionBean.setShares(Long.parseLong(transanctionForm.getShares()));

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
