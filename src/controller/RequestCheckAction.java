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
import databean.TransactionBean;
import formbean.RequestCheckForm;
import model.Model;
import model.TransactionDAO;

public class RequestCheckAction extends Action {
	private FormBeanFactory<RequestCheckForm> formBeanFactory = FormBeanFactory.getInstance(RequestCheckForm.class);
	private TransactionDAO transactionDAO;

	public RequestCheckAction(Model model) {
		transactionDAO = model.getTransactionDAO();
	}

	public String getName() {
		return "requestCheck.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("user") == null) {
			return "login.do";
			}
			RequestCheckForm form = formBeanFactory.create(request);
			request.setAttribute("form",form);
			
			if (!form.isPresent()) {
				return "requestCheck.jsp";
			}
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "requestCheck.jsp";
			}

			CustomerBean user = (CustomerBean) request.getSession().getAttribute("user");
			System.out.println(user.getUserName());
			System.out.println(user.getCustomerId());

			TransactionBean[] arr = transactionDAO.match(MatchArg.and ( MatchArg.equals("customerId", user.getCustomerId()),
					MatchArg.equals("executeDate", "")));
			System.out.println(arr);

			long amount = 0;
			for (TransactionBean bean : arr) {
				amount += bean.getAmount();
			}
			String s = form.getRequestAmount();
			amount += Long.parseLong(s);
			System.out.println(amount);
			if (user.getCash() < amount) {
				errors.add("Balance is not enough to proceed the request");
				return "requestCheck.jsp";
			} 
			System.out.println("transaction");
			TransactionBean tBean = new TransactionBean();
			tBean.setCustomerId(user.getCustomerId());
			System.out.println(user.getCustomerId());
			tBean.setTransactionType("Request Check");
			System.out.println("Request Check");
			tBean.setAmount(Long.parseLong(s));
			System.out.println(Long.parseLong(s));
			transactionDAO.create(tBean);
			System.out.println("create");
			return "success-customer.jsp";
			
		} catch (RollbackException e) {
			errors.add("System roll back");
			return "requestCheck.jsp";
		} catch (FormBeanException e1) {
			errors.add("Form data wrong");
			return "requestCheck.jsp";
		}
	}
}
