package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanFactory;

import databean.CustomerBean;
import databean.TransactionBean;
import formbean.RequestCheckForm;
import model.CustomerDAO;
import model.Model;
import model.TransactionDAO;

public class RequestCheckAction {
	private FormBeanFactory<RequestCheckForm> formBeanFactory = FormBeanFactory.getInstance(RequestCheckForm.class);
	private CustomerDAO customerDAO;
	private TransactionDAO transactionDAO;
	
	public RequestCheckAction(Model model) {
		customerDAO = model.getCustomerDAO();
		transactionDAO = model.getTransactionDAO();
	}
	
	public String getName() {
		return "requestCheck.do";
	}

	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		
		if (session.getAttribute("user") == null) {
			return "login.do";
		}
		
		CustomerBean user = (CustomerBean) request.getSession().getAttribute("user");
		TransactionBean[] arr;
		try {
			arr = transactionDAO.match(MatchArg.and(MatchArg.equals("customerId", user.getCustomerId()), MatchArg.equals("executeDate", "TransactionDay")));
		
		int amount = 0;
		for (TransactionBean bean : arr) {
			amount += bean.getAmount(); 
		}
		amount += (int) request.getSession().getAttribute("checkAmount");
		if (user.getCash() < amount) {
			errors.add("Balance is not enough to proceed the request");
			return "requestCheck.jsp";
		}
		else {
			return "sucess.jsp";
		}
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			errors.add("Sytem roll back");
			return "requestCheck.jsp";
		}
	}
	

}
