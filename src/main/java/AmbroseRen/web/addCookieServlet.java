package AmbroseRen.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		Cookie c =new Cookie("username","King");
		c.setMaxAge(40);
		response.addCookie(c);
		Cookie c2 =new Cookie("city","boom");
		response.addCookie(c2);
	}

}