package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.CommandAction;


public class LogoutAction implements CommandAction {
	 public String requestPro(HttpServletRequest request,
		        HttpServletResponse response)throws Throwable {

		        return "/logon/logout.jsp";
		    }
		}
