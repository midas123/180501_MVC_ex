package action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.CommentDataBean;
import comment.CommentDBBean;


public class CommentWriteAction implements CommandAction {
	public String requestPro (HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		
		int pagenum = Integer.parseInt(request.getParameter("pageNum"));
		String num = request.getParameter("num");
		String mnum = request.getParameter("mnum");
		System.out.println("¿©±â:"+mnum);
		
		
		
		CommentDataBean comment = new CommentDataBean();
		comment.setMNum(Integer.parseInt(request.getParameter("mnum")));
		comment.setCom_re_level(Integer.parseInt(request.getParameter("com_re_level")));
		comment.setCom_re_set(Integer.parseInt(request.getParameter("com_re_set")));
		comment.setCom_re_step(Integer.parseInt(request.getParameter("com_re_step")));
		comment.setContent_num(Integer.parseInt(num));
		comment.setMNum(Integer.parseInt(mnum));
		comment.setCommentt((request.getParameter("commentt")));
		comment.setCommenter((request.getParameter("commenter")));
		comment.setPasswd(request.getParameter("passwd"));
		comment.setReg_date(new Timestamp(System.currentTimeMillis()));
		comment.setIp(request.getRemoteAddr());
		
			
			
		CommentDBBean cdb = CommentDBBean.getInstance();
		cdb.insertComment(comment);
		
		
		request.setAttribute("pageNum", pagenum);
		request.setAttribute("num", num);
		
		
		
		return "/MVC/commentWrite.jsp";
	}
}
