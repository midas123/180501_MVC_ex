package action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.CommentDataBean;
import comment.CommentDBBean;


public class CommentDeleteAction implements CommandAction {
	public String requestPro (HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		
		int pagenum = Integer.parseInt(request.getParameter("pageNum"));
		int content_num = Integer.parseInt(request.getParameter("content_num"));
		String passwd = request.getParameter("passwd");
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		
		CommentDBBean comment = CommentDBBean.getInstance();
		comment.deleteComment(content_num, passwd, comment_num);
		
		request.setAttribute("pageNum", pagenum);
		request.setAttribute("content_num", content_num);
		
		
		
		return "/MVC/commentDeletePro.jsp";
	
		
	}
	
}
