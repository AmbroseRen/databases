package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import AmbroseRen.network.JDBC.EmpDao;
import AmbroseRen.network.JDBC.Emp;
import AmbroseRen.network.JDBC.DBUtil;

public class JDBC03 {
	
	/**
	 * 批量添加108个员工，每批发送50条数据
	 */
	@Test
	public void test1(){
		Connection conn =null;
		try {
			conn =DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into emps_Amb "
					+ "values(emps_seq_Amb.nextval,?,?,?,?,?,?,?)";
			PreparedStatement ps =conn.prepareStatement(sql);
			for(int i=0;i<=108;i++){
				ps.setString(1, "好汉"+i);
				ps.setString(2, "打劫");
				ps.setInt(3, 0);
				ps.setDate(4, Date.valueOf("2017-08-22"));
				ps.setDouble(5, 3000.0);
				ps.setDouble(6, 9000.0);
				ps.setInt(7, 3);
				ps.addBatch();//将此数据批量暂存到ps对象上
				if(i%50==0){
					ps.executeBatch();//将ps上暂存的50条数据发送给数据库
					ps.clearBatch();//将ps上暂存的数据清空，以便下一次发送
				}
			}
			ps.executeBatch();//单独发送最后一批的零头数据
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.rollback(conn);
		}finally{
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 先增加一个部门，再给此部门增加一个员工.
	 * 在增加员工时，需要使用刚刚增加的部门的ID
	 */
	@Test
	public void test2(){//-------------------------------------
//		假设网页传入的数据如下：
		//部门数据
		String dname = "设计部";
		String loc = "天津";
		//员工数据
		String ename = "八戒";
		String job = "二把手";
		int mgr = 0;
//		获取时间量
		Date hiredate =new Date(System.currentTimeMillis());
		double sal = 8000.0;
		double comm = 5000.0;
		Connection conn =null;
		try {
			conn =DBUtil.getConnection();
			conn.setAutoCommit(false);
			//增加部门数据
			String sql = "insert into depts_Amb values(depts_seq_Amb.nextval,?,?)";
//									第二个参数(deptno):是一个字符串数组，内含主键字段名，用ps取得主键元素字段值
			PreparedStatement ps = conn.prepareStatement(sql,new String[]{"deptno"});
			ps.setString(1, dname);
			ps.setString(2, loc);
			ps.executeUpdate();//刷新
			ResultSet rs = ps.getGeneratedKeys();//获得生成的主键的值
			rs.next();//基于指针读取
			//获取主键值不能通过字段值获取，只能通过序号获取
			int deptno =rs.getInt(1);  
			
			//增加员工
			 sql = "insert into emps_Amb values(emps_seq_Amb.nextval,?,?,?,?,?,?,?)";
			 ps =conn.prepareStatement(sql);
			 ps.setString(1, ename);
			 ps.setString(2, job);
			 ps.setInt(3, mgr);
			 ps.setDate(4, hiredate);
			 ps.setDouble(5, sal);
			 ps.setDouble(6, comm);
			 ps.setInt(7, deptno);
			 ps.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.rollback(conn);
		}finally{
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 查询第二页的员工的数据
	 */
	@Test
	public void test3(){
		//假设需求规定
		int size = 10;
		//假设用户点击
		int page = 2;
		
		Connection conn =null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "select * from(	select rownum rn,"
					+ "e.*from(	select * from emps_Amb order by empno) e)"
					+ " where rn between ? and ?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*size+1);
			ps.setInt(2, page*size);
			ResultSet rs = ps.executeQuery();//再传sql重复传参了
			while(rs.next()){
				System.out.println(rs.getInt("empno"));
				System.out.println(rs.getString("ename"));
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.rollback(conn);
		}finally{
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 测试EmpDao中的findById和update（）
	 */
	@Test
	public void test4(){
		EmpDao dao =new EmpDao();//先调类
		Emp e =dao.findById(22);//再调子方法
		System.out.println(e);
		//方法下设置参数的引用
		e.setEname("李青云");
		e.setJob("大王");
		dao.update(e);
	}
	
	@Test
	public void test41(){
		EmpDao dao =new EmpDao();
//		SimpleDateFormat sdf =new SimpleDateFormat("YYYY-MM-DD");
//		Emp e =dao.update("魔尊","统帅",0,sdf.parse("2017-08-22"),5000.0,3000.0,2,23);
		 
		Emp e =new Emp();//引用设置Emp的参数
		e.setEmpno(32);
		e.setEname("魔尊");
		e.setSal(6000.0);
		e.setComm(4000.0);
		e.setDeptno(5);
		e.setMgr(0);
		dao.update(e);
	}
	
	/**
	 * 测试EmpDao中的findByPage（）
	 */
	@Test
	public void test5(){
		EmpDao dao =new EmpDao();
		List<Emp> list =dao.findByPage(2,10);
		for(Emp e:list){
			System.out.println(e);
		}
		/*方法二：迭代器----------------------------------*/
		
	}
	
}