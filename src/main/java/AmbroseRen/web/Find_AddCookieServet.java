package AmbroseRen.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Find_AddCookieServet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		Cookie[] c =request.getCookies();		
		if(c !=null){
			boolean flag =false;
			for (int i = 0; i < c.length; i++) {
				String name =c[i].getName();
				String value =c[i].getValue();
				if("cart".equals(c[i].getName())){
					out.println("该Cookie已存在");
					flag =true;
				}
			}
			if(!flag){
				Cookie c0 =new Cookie("cart","1,2,3");
				response.addCookie(c0);
			}
		}else{
			Cookie c0 =new Cookie("cart","1,2,3");
			response.addCookie(c0);
		}
	}

}
