package AmbroseRen.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sendData extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException
	{
		response.setContentType("text/html;charset=utf-8");//将数据写到发送包里
		//System.out.println("请输入你的体重...");
		//System.out.println("请输入你的身高...");
		String weight =request.getParameter("weight");
		double wh =Double.parseDouble(weight);
		System.out.println(wh);
		String height =request.getParameter("height");
		double hh =Double.parseDouble(height);
		double bmi =wh/hh/hh;
		PrintWriter out =response.getWriter();
		if(bmi>25){
			out.println("过重");
		}else if(bmi<19){
			out.println("过轻");
		}else{
			out.println("正常");
		}
		out.close();
	}
}
