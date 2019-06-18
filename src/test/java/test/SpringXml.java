package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import AmbroseRen.annotation.Student;
import AmbroseRen.annotation.extractStudent;

public class SpringXml {
	//Xml参数注入
	@Test
	public void test1(){
		String config ="springIOC.xml";
		ApplicationContext ac =new ClassPathXmlApplicationContext(config);
		Student stu1 =ac.getBean("stu1",Student.class);
		System.out.println(stu1);
		System.out.println(stu1.getName());
	}
	
	//Spring表达式提取参数
	@Test
	public void test2(){
		String config ="springIOC.xml";
		ApplicationContext ac =new ClassPathXmlApplicationContext(config);
		extractStudent extractStudent =ac.getBean("extract",extractStudent.class);
		System.out.println(extractStudent);
	}
	
	//各个集合注入演示
	@Test
	public void test3(){
		String config ="springIOC.xml";
		ApplicationContext ac =new ClassPathXmlApplicationContext(config);
		Student stu2 =ac.getBean("stu2",Student.class);
		System.out.println(stu2);
		System.out.println(stu2.getName());
		System.out.println(stu2.getInterest().get(1));
		System.out.println(stu2.getDb().getProperty("uname"));
	}
	
	@Test
	public void test4(){

		System.out.println("");
	}
	
	@Test
	public void test5(){

		System.out.println("");
	}
	
	@Test
	public void test6(){

		System.out.println("");
	}
	
	@Test
	public void test7(){

		System.out.println("");
	}
	
	@Test
	public void test8(){

		System.out.println("");
	}
}
