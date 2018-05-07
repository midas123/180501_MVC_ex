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
	private Map commandMap = new HashMap(); //명령어와 명령어 처리 클래스를 쌍으로 저장
	
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
	
	//시용자의 요청을 분석해서 해당 작업을 처리
	private void requestPro (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		CommandAction com=null;
		
	try {
		String command = request.getRequestURI();
		//요청 URL이 웹 프로젝트 폴더의 경로에 포함되면 0을 리턴
		if(command.indexOf(request.getContextPath()) ==0) {
			//command에서 프로젝트 경로 만큼을 제외
			command = command.substring(request.getContextPath().length());
		}
		
		//URL 명령어에 해당하는 클래스를 com에 담는다.
		com = (CommandAction)commandMap.get(command);
		if(com == null) {
			com = new NullAction();
		}
		//해당 액션클래스가 로직을 수행하고 리턴한 URL을 view에 담는다.
		view = com.requestPro(request, response);
	    } catch(Throwable e) {
	    	throw new ServletException(e);
	    }
	//사용자의 요청이 담긴 객체를 정의하고 서블릿,jsp,html 등으로 보내는 클래스
	RequestDispatcher dispatcher =request.getRequestDispatcher(view);
	// Forwards a request from a servlet to another resource (servlet, JSP file, or HTML file) on the server.
    dispatcher.forward(request, response);
	}
}
