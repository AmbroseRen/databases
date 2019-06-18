package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import AmbroseRen.network.JDBC.DBUtil;

public class JDBC02 {

	/**
	 * 测试DBUtil
	 */
	@Test
	public void Test1() {
		// 假设页面传入的删除条件是
		int empno = 1;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			System.out.println(conn);
			Statement smt = conn.createStatement();// 调用sql
			String sql = "delete from emps_Amb where empno=" + empno;
			smt.executeUpdate(sql);// 执行
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	@Test
	public void Test2() {
		int empno = 21;
		Connection conn = null;
		try {
			// 建立连接
			conn = DBUtil.getConnection();
			String sql = "select * from emps_Amb where empno=? ";

			PreparedStatement ps = conn.prepareStatement(sql);// 动态表达式
			// 给？赋值-----ps.set类型（?的顺序，？的值）
			ps.setInt(1, empno);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("ename"));
				System.out.println(rs.getDouble("sal"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	/**
	 * 使用PS对象执行DML语句
	 */
	@Test
	public void Test3() {
		// 假设网页传入的数据如下
		String ename = "张三";
		String job = "领导";
		int mgr = 0;
		Date hiredate = new Date(System.currentTimeMillis());
		// Date.valueOf("2017-08-22");法二
		Double sal = 6000.0;
		Double comm = 2000.0;
		int deptno = 1;

		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into emps_Ambrose values(emps_Ambrose_seq.nextval,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ename);
			ps.setString(2, job);
			ps.setInt(3, mgr);
			ps.setDate(4, hiredate);
			ps.setDouble(5, sal);
			ps.setDouble(6, comm);
			ps.setInt(7, deptno);
			ps.executeUpdate();// 执行
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	/**
	 * 模拟开发登录的业务，即使用PS执行查询语句，验证账号密码的正确性.
	 */
	@Test
	public void Test4() {
		// 假设网页传入的数据是
		String username = "zhangsan";
		String password = "a' or 'b'='b";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from users_Amb where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("登录成功");
			} else {
				System.out.println("账号或密码错误！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	/**
	 * 查看结果集元数据所包含的内容
	 */
	@Test
	public void Test5() {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from emps_Ambrose order by empno";
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			// 获取结果集的元数据
			ResultSetMetaData md = rs.getMetaData();
			System.out.println(md.getColumnCount());
			System.out.println(md.getColumnName(1));
			System.out.println(md.getColumnTypeName(1));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 *模拟实现转账的业务. 
	 *
	 *假设当前用户已经登录了网银，且已经输入了收款方的账号，和要转出的金额，
	 *且点击了转账按钮，服务器接收了相关信息，开始进行转账。
	 *
	 *转账的步骤：
	 */
	@Test
	public void Test6() {
		//假设用户输入了如下信息
		String payId = "00001";
		String recId = "00002";
		Double mny = 1000.0;
		//转账是一个完整的事物，需要保障在一个事务内，所以只需创建一个连接，来保障一个事物.		
		Connection conn =null;
		try {
			conn =DBUtil.getConnection();
			conn.setAutoCommit(false);
			//	1.查询付款方余额是否足够？
			String sql = "select * from accounts_amb where id=?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, payId);
			ResultSet rs =ps.executeQuery();
			rs.next();//指针滚动
				Double payMoney = rs.getDouble("money");
				if(payMoney<mny){
					System.out.println("余额不足！");
					return ;
				}
			//	2.查收款方账号是否存在？
			String sql2 ="select * from accounts_amb where id=?";
			PreparedStatement ps2 =conn.prepareStatement(sql2);
			ps2.setString(1, recId);
			ResultSet rs2 =ps.executeQuery();
			if(!rs2.next()){
				System.out.println("收款方账号不存在！");
				return;
			}
			double recMoney = rs2.getDouble("money");//收款方金额
			//	3.修改付款方余额，-N元
			String sql3 = "update accounts_amb set money =? where id=?";
			PreparedStatement ps3 =conn.prepareStatement(sql3);
			ps3.setDouble(1, payMoney-mny);
			ps3.setString(2, payId);
			ps3.executeUpdate();
						
			
			//	4.修改收款方余额，+N元
			String sql4 = "update accounts_amb set money =? where id=?";
			PreparedStatement ps4 =conn.prepareStatement(sql4);
			ps4.setDouble(1, recMoney+mny);
			ps4.setString(2, recId);
			ps4.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.rollback(conn);
		}finally{
			DBUtil.close(conn);
		}
	}

}
