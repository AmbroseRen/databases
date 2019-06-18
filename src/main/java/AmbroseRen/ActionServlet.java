package AmbroseRen;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import AmbroseRen.system.entity.Stock;
import AmbroseRen.common.dao.EmployeeDAO;
import AmbroseRen.common.entity.Employee;
import AmbroseRen.common.service.bmiService;


public class ActionServlet extends HttpServlet implements HandlerInterceptor{
	
	private static final long serialVersionUID = 1661820348211921278L;

	@Override
	protected void service(HttpServletRequest req,HttpServletResponse res)
		throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out =res.getWriter();
		String uri =req.getRequestURI();
		String action =uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));		
		
		if("/check".equals(action)){
			String uname =req.getParameter("uname");
			System.out.println("uname=="+uname);
			if("Sally".equals(uname)){
				out.println("用户名被占用");
			}else{
				out.println("可以使用");
			}			
		}else if("/getCity".equals(action)){
			String name =req.getParameter("name");
			if("bj".equals(name)){
				out.println("朝阳,cy;东城,dc");
			}else if("sh".equals(name)){
				out.println("静安,ja;黄埔，hp;浦东新,pdx");
			}else if("gz".equals(name)){
				out.println("白云,by;番禹,fy");
			}			
		}else if("/getSend".equals(action)){
			Random r =new Random();
			int number =r.nextInt(1000);
			System.out.println(number);
			out.println(number);			
		}else if("/quoto".equals(action)){
			//模拟生成股票信息
			List<Stock> stocks =new ArrayList<Stock>();
			Random r =new Random();
			for(int i=0;i<5;i++){
				Stock s =new Stock();
				s.setCode("60078"+r.nextInt(10));
				s.setName("中国嘉陵"+r.nextInt(10));
				s.setPrice(r.nextInt(10));
				stocks.add(s);
			}
			ObjectMapper om =new ObjectMapper();
			String jsonStr =om.writeValueAsString(stocks);
			System.out.println(jsonStr);
			//将json字符串发送给浏览器
			out.println(jsonStr);
		}else if ("/list".equals(action)) {
			try {
				EmployeeDAO dao =new EmployeeDAO();
				List<Employee> employees =dao.findAll();
				//List<Employee> delete =dao.delete();
				out.println("<table border='1' width='60%' cellspacing='0'>");
				out.println("<tr><td>ID</td><td>姓名</td><td>工资</td><td>年龄</td><td>修改</td></tr>");
				for(int i = 0;i < employees.size(); i++){
					Employee e = employees.get(i);
					out.println("<tr>"
							+ "<td>" + e.getId() + "</td>"+"<td>" + e.getEname() + "</td>" 
							+ "<td>" + e.getSalary() + "</td>"+"<td>" + e.getAge() + "</td>"
							+"<td><a href='del?id="+e.getId()+"'>删除</a>&nbsp"
							+ "<a href='update?id="+e.getId()+"'>修改</a></td>"	            			            	
							+ "</tr>");
				}   
				out.println("</table>");  
				out.println("<a href='addEmp.html'>添加新员工</a>");
			} catch (Exception e) {
				e.printStackTrace();
				out.println("系统错误");
			}			
		}else if ("/add".equals(action)) {
			String name =req.getParameter("name");
			String sal =req.getParameter("sal");
			//double salary =Double.parseDouble(sal);
			String age =req.getParameter("age");
			//int Age =Integer.parseInt(age);
			System.out.println(name);
			System.out.println(sal);
			System.out.println(age);
			try {
				//将员工信息插入到数据库
				EmployeeDAO dao =new EmployeeDAO();//调用sql将数据插入数据库
				Employee e =new Employee();//调方法加参数
				e.setEname(name);
				e.setSalary(Double.parseDouble(sal));
				e.setAge(Integer.parseInt(age));
				dao.save(e);
//				out.println("<h1>添加成功！</h1>");
//				out.println();
//				out.println("name:"+name);
//				out.println("salary:"+sal);
//				out.println("age:"+age);
//				out.println("<a href='url'>员工列表</a>");
				res.sendRedirect("list");//重定向发送内容
				
				out.println("<h1>输出添加成功!</h1>");
			} catch (Exception e2) {
				e2.printStackTrace();
				out.println("<h1>系统繁忙，请稍后重试...</h1>");
			}
			//容器会自动关闭out，不用调用out.close（）方法也可以
			out.close();			
		}else if ("/update".equals(action)) {
			EmployeeDAO dao =new EmployeeDAO();
			Employee e =new Employee();
			e.setId(Integer.parseInt("id"));
			e.setEname("ename");
			e.setSalary(Double.parseDouble("salary"));
			e.setId(Integer.parseInt("age"));
			
			try {
				dao.update(e);
			} catch (Exception e2) {
				e2.printStackTrace();
				out.println("更新失败！");
			}
			out.close();			
		}else if ("/bmi".equals(action)) {
			req.setCharacterEncoding("utf-8");
			String weight =req.getParameter("weight");
			String height =req.getParameter("height");
			//读取值
			String[] interest =req.getParameterValues("interest");
			if(interest !=null){			
				for(int i=0;i<interest.length;i++){
					System.out.println(interest[i]);
				}
			}
			String city =req.getParameter("city");
			System.out.println("city:"+city);
			
			double bmi= Double.parseDouble(weight)/
					Double.parseDouble(height)/Double.parseDouble(height);
			String status ="正常";
			if(bmi<19){
				status ="过轻";
			}else if(bmi>25){
				status ="过重";
			}
			res.setContentType("text/html;charset=utf-8");
			out =res.getWriter();
			out.println("<h1>你的bmi指数："+bmi+"身体状况："+status+"</h1>");
		}else if ("/toBmi".equals(action)) {
			req.getRequestDispatcher("/WEB-INF/bmi_form.jsp").forward(req, res);
		}else if ("/bmiO".equals(action)) {
			String height =req.getParameter("height");
			String weight =req.getParameter("weight");
			//调用逻辑处理代码
			bmiService bs =new bmiService();					
			String status =bs.bmi(Double.parseDouble(height), Double.parseDouble(weight));
			
			/**
			 * 依据模型返回的结果，调用对应的视图
			 */
			req.setAttribute("status", status);
			req.getRequestDispatcher("/WEB-INF/view.jsp").forward(req, res);
		}else{
			System.out.println("请求无效...");
		}
		
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
}
