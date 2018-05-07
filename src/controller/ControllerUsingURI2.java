package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import action.NullAction;

/*The servlet container creates an HttpServletRequest object and 
passes it as an argument to the servlet's service methods (doGet, doPost, etc).
*/

public class ControllerUsingURI2 extends HttpServlet{
	private Map commandMap = new HashMap(); //��ɾ�� ��ɾ� ó�� Ŭ������ ������ ����
	
	public void init(ServletConfig config) throws ServletException {
		String props = config.getInitParameter("configFile2");
		Properties pr = new Properties();
		FileInputStream f = null;
		
		try {
			String configFilePath = config.getServletContext().getRealPath(props);
			//C:\Users\yk\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\180501_MVC_ex\WEB-INF\commandHandlerURI.properties
			f = new FileInputStream(configFilePath);
			pr.load(f);
		} catch (IOException e) {
			throw new ServletException(e);
		} finally {
			if (f != null) try {f.close();} catch (IOException ex) {}
		}
		
		Iterator keyIter = pr.keySet().iterator();
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next();
			String className = pr.getProperty(command);
			
			try {
				Class commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();
				commandMap.put(command, commandInstance);
			} catch (ClassNotFoundException e) {
				throw new ServletException (e);
			} catch (InstantiationException e) {
				throw new ServletException (e);
			} catch (IllegalAccessException e) {
				throw new ServletException (e);
			}
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	//�ÿ����� ��û�� �м��ؼ� �ش� �۾��� ó��
	private void requestPro (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		CommandAction com=null;
		
	try {
		String command = request.getRequestURI();
		//��û URL�� �� ������Ʈ ������ ��ο� ���ԵǸ� 0�� ����
		if(command.indexOf(request.getContextPath()) ==0) {
			//command���� ������Ʈ ��� ��ŭ�� ����
			command = command.substring(request.getContextPath().length());
		}
		
		//URL ��ɾ �ش��ϴ� Ŭ������ com�� ��´�.
		com = (CommandAction)commandMap.get(command);
		if(com == null) {
			com = new NullAction();
		}
		//�ش� �׼�Ŭ������ ������ �����ϰ� ������ URL�� view�� ��´�.
		view = com.requestPro(request, response);
	    } catch(Throwable e) {
	    	throw new ServletException(e);
	    }
	//������� ��û�� ��� ��ü�� �����ϰ� ����,jsp,html ������ ������ Ŭ����
	RequestDispatcher dispatcher =request.getRequestDispatcher(view);
	// Forwards a request from a servlet to another resource (servlet, JSP file, or HTML file) on the server.
    dispatcher.forward(request, response);
	}
}
