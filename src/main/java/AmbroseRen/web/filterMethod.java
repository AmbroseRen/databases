package AmbroseRen.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class filterMethod implements Filter{
	private FilterConfig config;
	private FilterConfig size;
	/**
	 * 容器在销毁实例之前会，会调用此方法
	 */
	public void destroy() {
		System.out.println("destroy().start()...");
	}
	
	/**
	 * 容器会掉调用doFilter方法来处理请求
	 * FilterChain-----过滤器链条：子过滤器1如果通过，则继续执行请求
	 * 否则，不执行
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2)
		throws IOException, ServletException {
		System.out.println("doFilter().start()...");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		String content =request.getParameter("content");
		//读取非法参数
		String illegal =config.getInitParameter("illegal");
		String size =config.getInitParameter("size");
		System.out.println("size:"+size); 
		if(content.indexOf("杀")!=-1){
			out.println("<h1>评论非法</h1>");
		}else{
			System.out.println("continue...");
			arg2.doFilter(request, response);			
		}
		if(content.length()>size.length()){
			out.println("<h1>字数过多！</h1>");
		}
		System.out.println("doFilter()执行完毕！");
	}
	
	/**
	 * 容器启动后，会立即创建过滤器实例（只会创建一次），
	 * 接下来会创建该实例的init方法（只执行一次）
	 * FilterConfig：用来读取初始化参数
	 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init()的唯一创建");
		//将容器传递过来的FilterConfig对象保存下来
		config =arg0;
	}
	
	public filterMethod(){
		System.out.println("CommentFilter()");
	}
	
}
