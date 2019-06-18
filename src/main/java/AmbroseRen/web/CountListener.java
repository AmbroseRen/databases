package AmbroseRen.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener{
	/*
	 *session对象创建之后，会执行此方法事件对象
	 *arg0：事件对象 
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("sessionCreated()");
		//获取上下文session
		HttpSession session =arg0.getSession();
		ServletContext sc =session.getServletContext();
		//获取servlet上下文绑定的人数
		Integer count =(Integer)sc.getAttribute("count");
		if(count ==null){
			//第一个用户
			count =1;
		}else{
			count ++;
		}
		sc.setAttribute("count", count);
	}
	//sessio对象销毁之后，会执行此方法
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed()");
		ServletContext sc =arg0.getSession().getServletContext();
		Integer count =(Integer)sc.getAttribute("count");
		count --;
		sc.setAttribute("count", count);
	}
}
