package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databean.CustomerBean;
import databean.TransactionBean;
import formbean.DepositCheckForm;
import model.CustomerDAO;
import model.Model;
import model.TransactionDAO;

public class DepositCheckAction extends Action {

	private FormBeanFactory<DepositCheckForm> formBeanFactory = FormBeanFactory.getInstance(DepositCheckForm.class);
	private TransactionDAO transactionDAO;
	private CustomerDAO customerDAO;

	public DepositCheckAction(Model model) {
		transactionDAO = model.getTransactionDAO();
		customerDAO = model.getCustomerDAO();
	}

	public String getName() {
		return "depositCheck.do";
	}
	
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		HttpSession session = request.getSession();
		
		try {
			DepositCheckForm depisitCheckForm = formBeanFactory.create(request);
			request.setAttribute("form",depisitCheckForm);
			if (session.getAttribute("user") == null) {
				return "login.do";
			}
			
			if (!depisitCheckForm.isPresent()) {
				return "depositCheck.jsp";
			}
			errors.addAll(depisitCheckForm.getValidationErrors());
			if (errors.size() != 0) {
				return "depositCheck.jsp";
			}
			
			String s =  depisitCheckForm.getDepositAmount();
			CustomerBean customerBean = customerDAO.read(depisitCheckForm.getUserName());
			//System.out.println(customerBean.getUserName());
			if (customerBean == null) {
				errors.add("No such user!");
				return "depositCheck.jsp";
			}
			TransactionBean tBean = new TransactionBean();
			tBean.setCustomerId(customerBean.getCustomerId());

			tBean.setTransactionType("1");
			tBean.setAmount(Long.parseLong(s) + customerBean.getCash());

			transactionDAO.create(tBean);
			return "success-employee.jsp";
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			errors.add("Sytem roll back");
			return "depositCheck.jsp";
		} catch (FormBeanException e1) {
			// TODO Auto-generated catch block
			errors.add("Form data wrong");
			return "depositCheck.jsp";
		}
	}

}
