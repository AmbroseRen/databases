package AmbroseRen.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import AmbroseRen.system.service.impl.SystemServiceImpl;

@Controller
@RequestMapping("/system/")
public class SystemController {

	@Autowired
	@Qualifier("systemService")
	private SystemServiceImpl SystemServiceImpl;
	
	@RequestMapping("upLoad")
	public String attachmentUI(){
		return "plugins/upLoad";
	}
	
	@RequestMapping("login")
	public String login(){
		System.out.println("==loginController==");
		return "login";
	}
	
	@RequestMapping("index")
	public String index(){
		System.out.println("==indexController==");
		return "index";
	}
	
	@RequestMapping("menu")
	public String menu(){
		return "menu";
	}
	
	@RequestMapping("systemTest")
	public String systemTest(){
		return "system/systemTest";
	}
}
