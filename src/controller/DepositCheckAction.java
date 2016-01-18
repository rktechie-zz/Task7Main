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
			DepositCheckForm requestCheckForm = formBeanFactory.create(request);
			if (!requestCheckForm.isPresent() || errors.size() != 0) {
				return "requestCheck.jsp";
			}

			if (session.getAttribute("user") == null) {
				return "login.do";
			}
			String s = String.format("%.2f", session.getAttribute("depositAmount"));
			CustomerBean customerBean = customerDAO.read(session.getAttribute("userName"));
			TransactionBean tBean = new TransactionBean();
			tBean.setCustomer_id(customerBean.getCustomerId());
			tBean.setTransactionType("Deposit Check");
			tBean.setAmount(Long.parseLong(s));
			transactionDAO.create(tBean);
			return "success-employee.jsp";
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			errors.add("Sytem roll back");
			return "requestCheck.jsp";
		} catch (FormBeanException e1) {
			// TODO Auto-generated catch block
			errors.add("Form data wrong");
			return "requestCheck.jsp";
		}
	}

}