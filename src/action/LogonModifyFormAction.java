package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logon.LogonDataBean;
import logon.LogonDBBean;
import action.CommandAction;


public class LogonModifyFormAction implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String id = request.getParameter("id");
		
		LogonDBBean dbPro = LogonDBBean.getInstance();
		LogonDataBean member = dbPro.getMember(id);
		
		request.setAttribute("member", member);
		
		
		return "/logon/modifyForm.jsp";
	}

	
}
