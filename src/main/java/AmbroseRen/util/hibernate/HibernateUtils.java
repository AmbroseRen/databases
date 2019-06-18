package AmbroseRen.util.hibernate;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;
import AmbroseRen.annotation.Student;
 
public class HibernateUtils {
	private static final SessionFactory sessionFactory = buildSessionFactory();
 
	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration().configure();
		//4.2
		//ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		//5.0此项目不兼容
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		System.out.println("==");
		return configuration.buildSessionFactory(serviceRegistry);
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	

	@Test
	public void testFindAll(Student student) {
		SessionFactory sessionFactory=HibernateUtils.getSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();	
		
	}

	 /**
	  * 测一周时间
	 * @return
	 * @throws HibernateException
	 */
	/*public List exportOneweekinfo() throws HibernateException{
	        Session session = HibernateSessionFactory.getSession();
	        Transaction tx = session.beginTransaction();
	        Format ctime = new SimpleDateFormat("yyyy-MM-dd");
	        Date today = new Date();   
	        String todaydate = ctime.format(today);   //当前时间日期 
	        Calendar c = Calendar.getInstance();
	        c.setTime(today);
	        c.add(Calendar.DAY_OF_MONTH, -7);   
	        Date  before = c.getTime();
	        String beforeweekdate = ctime.format(before);    //一周开始的时间
	        System.out.println("todaydate"+todaydate);
	        System.out.println("beforweekdate"+beforeweekdate);  
	        Query query = session.createQuery("select e from Information as e where e.reporttime>='"+beforeweekdate+"' and e.reporttime <= '"+ todaydate +"'");   //hql语句
//	        query.setMaxResults(20);  //设置最大显示的个数
	        List list = query.list();
	        tx.commit();
	        HibernateSessionFactory.closeSession();
	        return list;
	}*/
	
	public static void main(String args[]){
		HibernateUtils.getSessionFactory();
	}
	
}

