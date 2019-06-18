package AmbroseRen.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import AmbroseRen.entity.User;
import AmbroseRen.service.LoginService;
import AmbroseRen.service.impl.AppException;

@Controller
public class LoginController {
	@Resource(name="loginService")
	private LoginService loginService;
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,HttpSession session){
		System.out.println("login()");
		String uname =request.getParameter("uname");
		String pwd =request.getParameter("pwd");
		System.out.println("uname:"+uname+",pwd:"+pwd);
		
		//将登录处理分发给业务层的对象来处理
		User user =loginService.checkLogin(uname, pwd);
		session.setAttribute("user", user);
		/*try {			
		} catch (Exception e) {
			e.printStackTrace();
			if(e instanceof AppException){
				//应用异常，需明确提示用户采取正确的操作
				request.setAttribute("login_failed", e.getMessage());
				return "login";
			}
			return "error";
		}*/
		//登录成功，重新定向到首页  
		return "redirect:toIndex.do";
	}
	@ExceptionHandler
	public String handleEx(HttpServletRequest request,Exception e){
		if(e instanceof AppException){
			request.setAttribute("login_failed", e.getMessage());
			return "login";
		}
		
		return "error";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		System.out.println("toIndex()");
		return "index";
	}
}
