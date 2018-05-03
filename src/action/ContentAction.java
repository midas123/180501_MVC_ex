package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDataBean;
import board.BoardDBBean;
import comment.CommentDBBean;

public class ContentAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		BoardDBBean dbPro = BoardDBBean.getInstance();
		BoardDataBean article = dbPro.getArticle(num);
		
		//´ñ±Û ºÎºÐ
		int pageSize=10;
		String cPageNum = request.getParameter("cPageNum");
		
		if(cPageNum == null)
		{
			cPageNum = "1";
		}
		int cCurrentPage = Integer.parseInt(cPageNum);
		int startRow = (cCurrentPage*10)-9;
		int endRow = cCurrentPage*pageSize;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		CommentDBBean cdb=CommentDBBean.getInstance();
		ArrayList comments=cdb.getComments(num,startRow, endRow);
		
		
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		request.setAttribute("comments", comments);
		
		return "/MVC/content.jsp";
		
	}

}
