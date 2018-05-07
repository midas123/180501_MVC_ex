package action;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

import logon.LogonDataBean;
import logon.LogonDBBean;
import action.CommandAction;

public class LogonInputProAction implements action.CommandAction{
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("euc-kr");
		LogonDataBean member = new LogonDataBean();
		member.setId(request.getParameter("id"));
        member.setPasswd(request.getParameter("passwd"));
        member.setName(request.getParameter("name"));
        member.setJumin1(request.getParameter("jumin1"));
        member.setJumin2(request.getParameter("jumin2"));
        member.setEmail(request.getParameter("email"));
        member.setBlog(request.getParameter("blog"));
        member.setReg_date(new Timestamp(System.currentTimeMillis()));
        
        LogonDBBean dbPro = LogonDBBean.getInstance();
        dbPro.insertMember(member);
        
        return "/logon/inputPro.jsp";
	}

}
