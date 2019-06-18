package AmbroseRen.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import AmbroseRen.common.entity.Bmi;

@Controller
public class BmiController {
	@RequestMapping("/toBmi")
	/**
	 * DispatcherServlet利用java反射分析处理器的方法签名（方法名，参数，返回类型），
	 * 然后将需要的对象作为参数传进来。
	 * 如：此处传进来的request参数
	 */
	public String bmi(HttpServletRequest request){
		System.out.println("bmi()");
		String height =request.getParameter("height");
		String weight =request.getParameter("weight");
		return "bmi";
	}
	
	@RequestMapping("/bmi2.do")
	/**
	 * DispatcherServlet利用java反射分析方法的签名（），
	 * 会将参数值赋给对应的形参
	 * 注：可以使用@RequestParam注解告诉Dispatcherservlet
	 * 形参名与请求名的对应关系
	 * @param weight
	 * @return
	 */
	public String bmi(String height,String weight){
		System.out.println("bmi2()");
		System.out.println(height+""+weight);
		return "view";
	}
	
	/**
	 *
	 */
	@RequestMapping("/bmi3.do")
	public String bmi3(Bmi bp){
		System.out.println("bmi3()");
		System.out.println(bp.getHeight()+""+bp.getWeight());
		return "view";
	}
	
	@RequestMapping("/bmi4.do")
	public String bmi4(Bmi bp,HttpServletRequest request){
		System.out.println("bmi4()");
		double height =bp.getHeight();
		double weight =bp.getWeight();
		double bmi =weight/height/height;
		String status="正常";
		if(bmi<19){
			status ="过轻";
		}
		if(bmi>25){
			status ="过重";
		}
		request.setAttribute("status", status);
		//默认就是转发
		return "view";
	}
	
	@RequestMapping("/bmi5.do")
	public ModelAndView bmi5(Bmi bp){
		System.out.println("bmi5()");
		double height =bp.getHeight();
		double weight =bp.getWeight();
		double bmi =weight/height/height;
		String status="正常";
		if(bmi<19){
			status ="过轻";
		}
		if(bmi>25){
			status ="过重";
		}
		/**
		 * 将数据添加到ModelAndView
		 * DispatcherServlet会将数据取出来，
		 * 然后绑定到request上（以key做为绑定名）
		 */
		Map<String,Object> data =new HashMap<String,Object>();
		data.put("status", status);
		ModelAndView mav =new ModelAndView("view",data);
		return mav;
	}
	
	@RequestMapping("/bmi6.do")
	public String bmi6(Bmi bp,ModelMap mm){
		System.out.println("bmi6()");
		double height =bp.getHeight();
		double weight =bp.getWeight();
		double bmi =weight/height/height;
		String status="正常";
		if(bmi<19){
			status ="过轻";
		}
		if(bmi>25){
			status ="过重";
		}
		//DispatcherServlet会从ModelMap中取出数据，
		//然后绑定到request上（以key做为绑定名）
		mm.addAttribute("status",status);
		
		return "view";
	}
	
	@RequestMapping("/bmi7.do")
	public String bmi7(Bmi bp,HttpSession session){
		System.out.println("bmi7()");
		double height =bp.getHeight();
		double weight =bp.getWeight();
		double bmi =weight/height/height;
		String status="正常";
		if(bmi<19){
			status ="过轻";
		}
		if(bmi>25){
			status ="过重";
		}
		session.setAttribute("status", status);
		return "view";
	}
	
	@RequestMapping("/bmi8.do")
	public String bmi8(Bmi bp){
		System.out.println("bmi8()");
		return "redirect:toIndex.do";
	}
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		System.out.println("toIndex()");
		return "index";
	}
	
	@RequestMapping("/bmi9.do")
	public ModelAndView bmi9(){
		System.out.println("bmi9()");
		RedirectView rv = new RedirectView("toIndex.do");
		ModelAndView mav =new ModelAndView(rv);
		return mav;
	}
	//--------------------------
	@RequestMapping("/emplist.do")
	public String emp(String uname,String pwd){
		System.out.println("emp()");
//		Scanner sc =new Scanner(System.in);
//		System.out.println("请输入用户名和密码...");
//		String uname =sc.nextLine();
//		String pwd =sc.nextLine();
		return "redirect:login.do";
	}
	@RequestMapping("/login.do")
	public String login(Bmi bp){
		System.out.println("login()");
		System.out.println(bp.getUname());
		System.out.println(bp.getPwd());
		return "index";
	}
}
