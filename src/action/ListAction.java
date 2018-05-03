package action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import comment.CommentDBBean;


public class ListAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String pageNum = request.getParameter("pageNum");
		String search = request.getParameter("search");
		int searchn=0;//�˻��� ����(0:�ۼ���, 1:����, 2:����)
		
		
		if(pageNum == null) {
			pageNum ="1";
		}
		int pageSize = 10;//�� �������� ���� ����
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;//�� �������� ���۱� ��ȣ
        int endRow = currentPage * pageSize;//�� �������� ������ �۹�ȣ
        int count = 0;
        int number=0;
        
	        
      //�˻���� �ڵ�
        if(search ==null){
    		search ="";
    	} else {
    		searchn = Integer.parseInt(request.getParameter("searchn"));
    	}
      //�˻���� �ڵ� 
	        
        
        List articleList = null;
        BoardDBBean dbPro = BoardDBBean.getInstance();//DB����
        //count = dbPro.getArticleCount();//��ü ���� ��
       

    	if(search.equals("") || search == null)
    		count = dbPro.getArticleCount();
    	else
    		count = dbPro.getArticleCount(searchn,search);
        
        
        //�˻���� �ڵ�
        if(count>0)
    	{
    		if(search.equals("") || search == null)
    			articleList = dbPro.getArticles(startRow, endRow);
    		else
    			articleList = dbPro.getArticles(startRow, endRow, searchn, search);
    	}
        //�˻���� �ڵ�
        
        	
        
        
        
//	        if (count > 0) {
//	            articleList = dbPro.getArticles(startRow, endRow);//���� �������� �ش��ϴ� �� ���
//	        } else {
//	            articleList = Collections.EMPTY_LIST;
//	        }
//	      
        
        
        number = count - (currentPage-1)*pageSize;//�۸�Ͽ� ǥ���� �۹�ȣ
        //�ش� �信�� ����� �Ӽ�
        
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
        request.setAttribute("number", new Integer(number));
        request.setAttribute("articleList", articleList);
        request.setAttribute("search", new String(search));
        request.setAttribute("searchn", new Integer(searchn));
        
        return "/MVC/list.jsp";
	}

}
