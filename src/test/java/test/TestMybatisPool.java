package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import AmbroseRen.dao.EmployeeDAO;
import AmbroseRen.entity.Employee;

public class TestMybatisPool {
	
	private EmployeeDAO dao;
	
	@Before
	public void init(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("mybatis/spring-mybatis.xml");
		 dao =ac.getBean("empDAO",EmployeeDAO.class);
		
	}
	
	@Test
	public void test1(){		
		Employee e =new Employee();
		e.setEname("苍老师2");
		e.setSalary(6000);
		e.setAge(24);
		dao.save(e);
		
	}
	
	@Test
	public void test2(){
		List<Employee> employees =dao.findAll();
		System.out.println(employees);
	}
	
	@Test
	public void test3(){
		
	}
}
