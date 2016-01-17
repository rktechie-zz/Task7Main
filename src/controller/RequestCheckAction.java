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
import formbean.LoginForm;
import formbean.RequestCheckForm;
import model.CustomerDAO;
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
			RequestCheckForm requestCheckForm = formBeanFactory.create(request);
			if (!requestCheckForm.isPresent() || errors.size() != 0) {
				return "requestCheck.jsp";
			}

			if (session.getAttribute("user") == null) {
				return "login.do";
			}

			CustomerBean user = (CustomerBean) request.getSession().getAttribute("user");
			TransactionBean[] arr;

			arr = transactionDAO.match(MatchArg.and(MatchArg.equals("customerId", user.getCustomerId()),
					MatchArg.equals("executeDate", null)));

			long amount = 0;
			for (TransactionBean bean : arr) {
				amount += bean.getAmount();
			}
			String s = String.format("%.2f", session.getAttribute("requestAmount"));
			amount += Long.parseLong(s);
			if (user.getCash() < amount) {
				errors.add("Balance is not enough to proceed the request");
				return "requestCheck.jsp";
			} else {
				TransactionBean tBean = new TransactionBean();
				tBean.setCustomer_id(user.getCustomerId());
				tBean.setTransactionType("Request Check");
				tBean.setAmount(Long.parseLong(s));
				transactionDAO.create(tBean);
				return "success.jsp";
			}
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
