package AmbroseRen;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AmbroseRen.system.dao.impl.EmployeeDAO;
import AmbroseRen.system.entity.Employee;

public class ActionServlet1 extends HttpServlet{

	private static final long serialVersionUID = -4028987070862778912L;

	@Override
	protected void service(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out =res.getWriter();
		String uri =req.getRequestURI();
		String action =uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		
		if("/list".equals(action)){
			try {
				EmployeeDAO dao =new EmployeeDAO();
				List<Employee> employees =dao.findAll();
				//绑定数据到request。
				req.setAttribute("employees", employees);
				//获得转发器
				RequestDispatcher rd =req.getRequestDispatcher("/WEB-INF/demo/empList3.jsp");
				//转发
				rd.forward(req,res);
			} catch (Exception e) {
				e.printStackTrace();
				out.println("查询错误");
			}
		}else
		if("/load".equals(action)){
			String id =req.getParameter("id");
			EmployeeDAO dao =new EmployeeDAO();
			try {
				Employee e =dao.findById(Integer.parseInt(id));
				req.setAttribute("e", e);
				req.getRequestDispatcher("/WEB-INF/demo/updateEmp.jsp").forward(req, res);		
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("打包失败...");
			}
		}else
		if("/add".equals(action)){
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
				res.sendRedirect("list.dd");//重定向发送内容
				
				out.println("<h1>输出添加成功!</h1>");
			} catch (Exception e2) {
				e2.printStackTrace();
				out.println("<h1>系统繁忙，请稍后重试...</h1>");
			}
			//容器会自动关闭out，不用调用out.close（）方法也可以
			out.close();
		}else
		if("/update".equals(action)){
			String id =req.getParameter("id");
			String ename =req.getParameter("ename");
			String salary =req.getParameter("salary");
			String age =req.getParameter("age");
			EmployeeDAO dao =new EmployeeDAO();
			Employee e =new Employee();
			e.setId(Integer.parseInt(id));
			e.setEname(ename);
			e.setSalary(Double.parseDouble(salary));
			e.setAge(Integer.parseInt(age));
			try {
				dao.update(e);
				res.sendRedirect("list.dd");
				System.out.println("已提交修改！");
			} catch (Exception e2) {
				e2.printStackTrace();
				out.println("修改失败！");
			}
			out.close();
		}else
		if("/del".equals(action)){
			String id =req.getParameter("id");
			try {
				EmployeeDAO del =new EmployeeDAO();
				del.delete(Integer.parseInt(id));//？？
				res.sendRedirect("list.dd");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("删除失败！");
			}
			out.close();
		}else
		if("/toAdd".equals(action)){
			req.getRequestDispatcher("/WEB-INF/demo/addEmp.jsp").forward(req, res);
		}		
	}
	
}
