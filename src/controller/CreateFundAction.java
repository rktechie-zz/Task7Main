package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FundDAO;
import model.Model;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databean.CustomerBean;
import databean.EmployeeBean;
import databean.FundBean;
import formbean.CreateFundForm;

public class CreateFundAction extends Action{
	private FormBeanFactory<CreateFundForm> formBeanFactory = FormBeanFactory.getInstance(CreateFundForm.class);
	
	private FundDAO fundDAO; 
	
	public CreateFundAction(Model model) {
		fundDAO = model.getFundDAO();
	}
	
	@Override
	public String getName() {
		return "createFund.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
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
			CreateFundForm createFundForm = formBeanFactory.create(request);
			request.setAttribute("form", createFundForm);

			errors.addAll(createFundForm.getValidationErrors());
			if (!createFundForm.isPresent() || errors.size() != 0) {
				return "createFund.jsp";
			}
			
			FundBean fundBean = new FundBean();
			fundBean.setName(createFundForm.getName());
			fundBean.setFundId(createFundForm.getFundId());
			
			fundDAO.create(fundBean);
			return "success-employee.jsp";			
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "createFund.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "createFund.jsp";
		}
	}

}
