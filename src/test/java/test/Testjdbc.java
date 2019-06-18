package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import AmbroseRen.dao.impl.EmployeeDAO;
import AmbroseRen.entity.Employee;

public class Testjdbc {
	private EmployeeDAO dao;
	//junit在执行测试方法前，会先执行@Before修饰的方法
	@Before
	public void init(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("spring-jdbc.xml");
		 dao =ac.getBean("empDAO",EmployeeDAO.class);
	}
	@Test
	public void test1(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("spring-jdbc.xml");
		EmployeeDAO dao =ac.getBean("empDAO",EmployeeDAO.class); 
		Employee e =new Employee();
		e.setEname("小月");
		e.setSalary(20000);
		e.setAge(22);
		dao.save(e);
	}
	@Test
	public void test2(){
		List<Employee> employees =dao.findAll();
		System.out.println(employees);
	}
	@Test
	public void test3(){
		Employee e =dao.findById(2);
		System.out.println(e);
	}
	@Test
	public void test4(){
		Employee e =dao.findById(13);
		e.setAge(e.getAge()+10);
		e.setSalary(e.getSalary()*2);
		dao.update(e);
	}
	@Test
	public void test5(){
		dao.delete(12);
	}
}

