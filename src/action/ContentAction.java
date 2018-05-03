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
		int com_re_set =1, com_re_level=0, com_re_step=0, mnum=0, wid=0;
		
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
		
		try {
		request.setAttribute("num", new Integer(num));
		System.out.println(num);
		System.out.println("pageNum:"+pageNum);
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("com_re_level", com_re_level);
		request.setAttribute("com_re_set", com_re_set);
		request.setAttribute("com_re_step", com_re_step);
		request.setAttribute("mnum", mnum);
		request.setAttribute("wid", wid);
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		request.setAttribute("comments", comments);
		request.setAttribute("article", article);
		
		return "/MVC/content.jsp";
		
	}

}
