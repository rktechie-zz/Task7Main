package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databean.FundBean;
import databean.FundPriceHistoryBean;
import model.FundDAO;
import model.FundPriceHistoryDAO;
import model.Model;

public class ResearchFundAction extends Action {
	private FundDAO fundDAO;
	private FundPriceHistoryDAO fundPriceHistoryDAO;
	
	public ResearchFundAction(Model model) {
		fundDAO = model.getFundDAO();
		fundPriceHistoryDAO = model.getFundPriceHistoryDAO();
	}
	
	public String getName() {
		return "researchFund.do";
	}
	
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			return "login.do";
			}
		try {
			FundBean[] fbs = fundDAO.match();
			List<FundPriceHistoryBean[]> fundList = new ArrayList<>();
			for (int i = 0; i < fbs.length; i++) {
				FundPriceHistoryBean[] fphbs = fundPriceHistoryDAO.match(MatchArg.equals("fundId", fbs[i].getFundId()));
				Arrays.sort(fphbs);
				fundList.add(fphbs);
			}
			session.setAttribute("fundList", fundList);
			return "researchFund.jsp";
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "researchFund.jsp";
		}
	}


}
