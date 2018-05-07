package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.CommandAction;
import logon.LogonDBBean;


public class LogonZipcheckAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("euc-kr");
		
		String check = request.getParameter("check");
		String area3 = request.getParameter("area3");
		LogonDBBean manager = LogonDBBean.getInstance();
		Vector zipcodeList = manager.zipcodeRead(area3);
		int totalList = zipcodeList.size();
		
		
		
		request.setAttribute("check", check);
		request.setAttribute("zipcodeList", zipcodeList);
		request.setAttribute("totalList", totalList);
		
		return "/logon/Zipcheck.jsp";
	}
}
