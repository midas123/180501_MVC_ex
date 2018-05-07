package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.CommandAction;

public class LoginFormAction implements CommandAction {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		return "/logon/loginForm.jsp";
	}
}
