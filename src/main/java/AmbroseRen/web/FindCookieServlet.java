package AmbroseRen.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		Cookie[] cookies =request.getCookies();
		if(cookies !=null){
			for (int i = 0; i < cookies.length; i++) {
				String name =cookies[i].getName();
				String value =cookies[i].getValue();
				out.println("<h1>name:"+name+";value:"+value+"</h1>");
			}
		}else{
			out.println("<h1>没有cookie</h1>");
		}
	}

}