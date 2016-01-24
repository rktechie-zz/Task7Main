package controller;

import java.text.DecimalFormat;
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
import model.TransactionDAO;

public class LoginAction extends Action {
	private FormBeanFactory<LoginForm> formBeanFactory = FormBeanFactory.getInstance(LoginForm.class);

	private EmployeeDAO employeeDAO;
	private CustomerDAO customerDAO;
	private TransactionDAO transactionDAO;
	private Model model;
	DecimalFormat df2 = new DecimalFormat(	"###,##0.00");

	public LoginAction(Model model) {
		this.model = model;
		employeeDAO = model.getEmployeeDAO();
		customerDAO = model.getCustomerDAO();
		transactionDAO = model.getTransactionDAO();
	}

	public String getName() {
		return "login.do";
	}

	public String perform(HttpServletRequest request) {
		//System.out.println("InLoginAction!");
		HttpSession session = request.getSession();
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		if (session.getAttribute("user") != null) {
			if (session.getAttribute("user") instanceof EmployeeBean) {
				return "employeeHome.do";
			} else if (session.getAttribute("user") instanceof CustomerBean) {
				 
				try {
					CustomerBean tmp = (CustomerBean)session.getAttribute("user");
					CustomerBean user = customerDAO.read(tmp.getUserName());
					
					if (user == null) {
						return "index.jsp";
					}
					
					session.setAttribute("user", user);
					String lastDay = getLastDay(user);
					if(lastDay == null){
						String s = "No recent transactions";
						//System.out.println("checkpoint");
						session.setAttribute("lastDay", s);
					}
					else session.setAttribute("lastDay", lastDay);
					String s = df2.format(transactionDAO.getValidBalance(user.getUserName(), user.getCash() / 100.0));
					System.out.println(s);
					session.setAttribute("avai_cash",s);
					return "customerHome.do";
				} catch (RollbackException e) {
					errors.add(e.getMessage());
					return "index.jsp";
				}
				
			}
		}

		try {
			LoginForm loginForm = formBeanFactory.create(request);
			request.setAttribute("form", loginForm);
			//System.out.println("LoginFormCreated?"+loginForm.userNm);
			
			if (!loginForm.isPresent()) {
				return "index.jsp";
			}
			//System.out.println("checkpoint");
			errors.addAll(loginForm.getValidationErrors());
			//System.out.println(""+loginForm.getUserName());
			if ( (errors.size() != 0)) {
				//System.out.println("Returning to index.html");
				return "index.jsp";
			}
			if (loginForm.isEmployee()) {
				EmployeeBean user = employeeDAO.read(loginForm.getUserName());
				//System.out.println(user);
				if (user == null) {
					//System.out.println("FOrm not read");
					errors.add("Incorrect Username: Username not found.");
					return "index.jsp";
				}

				if (!user.getPassword().equals(loginForm.getPassword())) {
					errors.add("Incorrect password.");
					return "index.jsp";
				}
				session.setAttribute("user", user);

				return "employeeHome.do";
			} else if (loginForm.isCustomer()) {
				CustomerBean user = customerDAO.read(loginForm.getUserName());

				if (user == null) {
					errors.add("Incorrect Username: Username not found.");
					return "index.jsp";
				}

				if (!user.getPassword().equals(loginForm.getPassword())) {
					errors.add("Incorrect password.");
					return "index.jsp";
				}
				String lastDay = getLastDay(user);
				if(lastDay == null){
					String s = "No recent transactions";
					//System.out.println("checkpoint");
					session.setAttribute("lastDay", s);
				}
				else session.setAttribute("lastDay", lastDay);
				
				session.setAttribute("user", user);
				String s = df2.format(transactionDAO.getValidBalance(user.getUserName(), user.getCash() / 100.0));
				//System.out.println(s);
				session.setAttribute("avai_cash",s);
				return "customerHome.do";
			} else {
				return "index.jsp";
			}

		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "index.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "index.jsp";
		}
	}
	
	private String getLastDay(CustomerBean customer) throws RollbackException{
		TransactionDAO transactionDAO;
		transactionDAO = model.getTransactionDAO();
		String lastDay = transactionDAO.getLastDate(customer);
		//System.out.println(lastDay);
		return lastDay;
	}
}
