package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databean.CustomerBean;
import databean.EmployeeBean;
import formbean.LoginForm;
import model.CustomerDAO;
import model.EmployeeDAO;
import model.Model;

public class LoginAction extends Action {
	private FormBeanFactory<LoginForm> formBeanFactory = FormBeanFactory.getInstance(LoginForm.class);

	private EmployeeDAO employeeDAO;
	private CustomerDAO customerDAO;

	public LoginAction(Model model) {
		employeeDAO = model.getEmployeeDAO();
		customerDAO = model.getCustomerDAO();
	}

	public String getName() {
		return "login.do";
	}

	public String perform(HttpServletRequest request) {
		System.out.print("InLoginAction!");
		HttpSession session = request.getSession();
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		if (session.getAttribute("user") != null) {
			if (session.getAttribute("user") instanceof EmployeeBean) {
				return "employeeHome.do";
			} else if (session.getAttribute("user") instanceof CustomerBean) {
				return "customerHome.do";
			}
		}

		try {
			LoginForm loginForm = formBeanFactory.create(request);
			request.setAttribute("form", loginForm);

			errors.addAll(loginForm.getValidationErrors());
			if (!loginForm.isPresent() || errors.size() != 0) {
				return "login.jsp";
			}
			if (loginForm.isEmployee()) {
				EmployeeBean user = employeeDAO.read(loginForm.getUserName());

				if (user == null) {
					errors.add("Incorrect Username: Username not found.");
					return "login.jsp";
				}

				if (!user.getPassword().equals(loginForm.getPassword())) {
					errors.add("Incorrect password.");
					return "login.jsp";
				}
				session.setAttribute("user", user);

				return "employeeHome.do";
			} else if (loginForm.isCustomer()) {
				CustomerBean user = customerDAO.read(loginForm.getUserName());

				if (user == null) {
					errors.add("Incorrect Username: Username not found.");
					return "login.jsp";
				}

				if (!user.getPassword().equals(loginForm.getPassword())) {
					errors.add("Incorrect password.");
					return "login.jsp";
				}
				session.setAttribute("user", user);

				return "customerHome.do";
			} else {
				return "login.jsp";
			}

		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "login.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "login.jsp";
		}
	}
}
