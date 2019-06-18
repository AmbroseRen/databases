package AmbroseRen.bean;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import AmbroseRen.bean.MessageBean;

public class SpringBean {
	public static void main(String[] args) {
		String config = "springIOC.xml";
		/**
		 * ApplicationContext:接口
		 * ClassPathXmlApplicationContext:实现了上述接口的类
		 * 注：依据类路径查找配置文件，然后启动Spring容器 
		 */
		ApplicationContext ac =new ClassPathXmlApplicationContext(config);
		
		//通过容器获得对象
		Waiter wt1 =ac.getBean("wt1",Waiter.class);
		System.out.println("Waiter=="+wt1);
		
		MessageBean a1 =ac.getBean("mb1",MessageBean.class);
		System.out.println("MessageBean=="+a1);
		
		Calendar cal =ac.getBean("cal",Calendar.class);
		System.out.println(cal);
		
		Date time =ac.getBean("time",Date.class);
		System.out.println(time);
	}
	
}
