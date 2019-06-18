package test;

import java.sql.SQLException;

import org.junit.Test;

import AmbroseRen.common.dao.EmployeeDAO;
import AmbroseRen.common.entity.Employee;
import AmbroseRen.network.JDBC.DBUtil;

public class ActionServletTest {
	@Test
	public void test1() throws SQLException{
		System.out.println(DBUtil.getConnection());
	}
	@Test
	public void test2(){
		EmployeeDAO dao =new EmployeeDAO();
		Employee e =new Employee();
		e.setEname("七夜");
		e.setSalary(5000);
		e.setAge(20);
		dao.save(e);//测试方法类
	}
	@Test
	public void test3(){
		EmployeeDAO dao =new EmployeeDAO();
		dao.delete(3);
	}
	@Test
	public void test4(){
		EmployeeDAO dao =new EmployeeDAO();
		Employee e =dao.findById(3);
		System.out.println("查询成功！");
	}
	@Test
	public void test5(){
		EmployeeDAO dao =new EmployeeDAO();
		Employee e =new Employee();
		e.setAge(5);
		e.setEname("sdafs");
		e.setId(6);
		e.setSalary(500);
		Employee e1 = dao.update(e);
		System.out.println(e1);
	}
}
