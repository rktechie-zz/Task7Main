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
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		HttpSession session = request.getSession();
	
		try {
			CreateFundForm createFundForm = formBeanFactory.create(request);
			request.setAttribute("form", createFundForm);
			
			if (session.getAttribute("user") == null) {
				return "login.do";
			}
			
			if (!createFundForm.isPresent()) {
				return "createFund.jsp";
			}
			
			errors.addAll(createFundForm.getValidationErrors());
			if (errors.size() != 0) {
				return "createFund.jsp";
			}

			FundBean fundBean = new FundBean();
			fundBean.setName(createFundForm.getName());
			fundBean.setSymbol(createFundForm.getSymbol());
		
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
