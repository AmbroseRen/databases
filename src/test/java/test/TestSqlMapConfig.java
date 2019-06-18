package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import AmbroseRen.entity.Emp2;
import AmbroseRen.entity.Employee;

public class TestSqlMapConfig {
	
	private SqlSession session;
	
	@Before
	public void init(){
		SqlSessionFactoryBuilder ssfb =new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf =ssfb.build(TestCase.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml"));
		session =ssf.openSession();		
	}
	
	@Test
	public void test1(){
		Employee e =new Employee();
		e.setEname("月儿");
		e.setSalary(50000);
		e.setAge(22);
		session.insert("test.save",e);
		//提交事务、并关闭资源
		session.commit();
		session.close();
	}
	
	@Test
	public void test2(){
		List<Employee> employees =session.selectList("test.findAll");
		System.out.println(employees);
	}
	
	@Test
	public void test3(){
		Employee e =session.selectOne("test.findById",13);
		System.out.println(e);
		session.close();
	}
	
	@Test
	public void test4(){
		Employee e =session.selectOne("test.findById",13);
		e.setAge(e.getAge()*2);
		session.update("test.update",e);
		session.commit();
		session.close();
	}
	
	@Test
	public void test5(){
		session.delete("test.delete",22);
		session.commit();
		session.close();
	}
	
	@Test
	public void test6(){
		Map map =session.selectOne("test.findById2",1);
		System.out.println(map);
		session.close();
	}
	
	@Test
	public void test7(){
		Emp2 emp =session.selectOne("test.findById3",1);
		System.out.println(emp);
		session.close();
	}
	
	//-----------------------------------------------------
	@Test
	public void test8(){
		//SqlSessionFactoryBuilder ssfb =session.getMapper(EmployeeDAO.class);
	}
	
}
