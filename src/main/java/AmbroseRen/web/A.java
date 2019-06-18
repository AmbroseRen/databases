package AmbroseRen.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class A extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		//使用继承自GenericServlet的方法来获取上下文
		ServletContext sc =getServletContext();		
		sc.setAttribute("uname", "Sally");
		//读取全局的初始化参数 
		String company =sc.getInitParameter("company");
		System.out.println(company);
	}

}
