package test;

import java.util.Calendar;
import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import AmbroseRen.bean.MessageBean;
import AmbroseRen.bean.Restaurant;
import AmbroseRen.annotation.Manager;
import AmbroseRen.bean.ExampleBean;
import AmbroseRen.bean.A;
import AmbroseRen.bean.Config;

public class SpringBean {
	
	//默认加载xml文件，并创建配置文件中的对象
	@Test
	public void test5(){
		String config = "springIOC.xml";
		ApplicationContext ac =new ClassPathXmlApplicationContext(config);
	}

	//config类配置测试
	@Test
	public void test1(){
		String config = "springIOC.xml";
		AbstractApplicationContext ac =new ClassPathXmlApplicationContext(config);
		Properties configs =ac.getBean("config",Properties.class);
		System.out.println("emailName=="+configs.getProperty("emailName"));
	}
	@Test
	public void test8(){
		String config = "springIOC.xml";
		AbstractApplicationContext ac =new ClassPathXmlApplicationContext(config);
		Manager mg =ac.getBean("mg",Manager.class);
		System.out.println("pageSize=="+mg.getPageSize());
	}
	
	
	//测试作用域
	@Test
	public void test2(){
		String config = "springIOC.xml";
		ApplicationContext ac =new ClassPathXmlApplicationContext(config);
		ExampleBean eb1 =ac.getBean("eb1",ExampleBean.class);
		ExampleBean eb2 =ac.getBean("eb1",ExampleBean.class);
		System.out.println(eb1==eb2);
	}
	
	//测试生命周期 相关的两个方法
	@Test
	public void test3(){
		String config = "springIOC.xml";
		/**
		 * ApplicationContext接口没有提供关闭容器的方法（close（）），
		 * 需要使用AbstractApplicationContext.
		 */
		AbstractApplicationContext ac =new ClassPathXmlApplicationContext(config);
		MessageBean mb1 =ac.getBean("mb1",MessageBean.class);
		mb1.init();
		mb1.sendMsg();
		ac.close();//关容器的流
	}
	
	//测试构造器注入
	@Test
	public void test4(){
		String config = "springIOC.xml";
		ApplicationContext ac =new ClassPathXmlApplicationContext(config);
		Restaurant rest1 =ac.getBean("rest1",Restaurant.class);
		System.out.println(rest1.toString());	
	}	
	
	//测试set方法的注入
	@Test
	public void test6(){
		String config = "springIOC.xml";
		ApplicationContext ac =new ClassPathXmlApplicationContext(config);
		A a =ac.getBean("a1",A.class);
		a.execute();
	}
	
	//测试(自动装配)
	@Test
	public void test7(){
		String config = "springIOC.xml";
		ApplicationContext ac =new ClassPathXmlApplicationContext(config);
		Restaurant rest1 =ac.getBean("rest1",Restaurant.class);
		System.out.println(rest1.toString());	
	}

	//
	@Test
	public void test9(){
		
	}
	
	@Test
	public void test10(){

		System.out.println("");
	}
	
}
