package action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDataBean;
import board.BoardDBBean;

public class WriteProAction implements CommandAction {
		public String requestPro (HttpServletRequest request, HttpServletResponse response) throws Throwable {
			request.setCharacterEncoding("euc-kr");
			BoardDataBean article = new BoardDataBean();
			article.setWriter(request.getParameter("writer"));
			article.setEmail(request.getParameter("email"));
			article.setSubject(request.getParameter("subject"));
			article.setPasswd(request.getParameter("passwd"));
			article.setReg_date(new Timestamp(System.currentTimeMillis()));
			article.setRef(Integer.parseInt(request.getParameter("ref")));
			article.setRe_level(Integer.parseInt(request.getParameter("re_level")));
			article.setRe_step(Integer.parseInt(request.getParameter("re_step")));
			article.setContent(request.getParameter("content"));
			article.setIp(request.getRemoteAddr());
			
			BoardDBBean dbPro = BoardDBBean.getInstance();
			dbPro.insertArticle(article);
			
			return "/MVC/writePro.jsp";
		
		
		}

}
