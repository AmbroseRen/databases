package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

import AmbroseRen.network.JDBC.DBTool;

/**
 * junit相关规则 1.测试方法必须公有 2.测试方法不能有返回值 3.测试方法不能有参数
 * 4.使用maven导入的包，将来Eclipse在拷贝项目到服务器中时， 也会被Eclipse一并拷贝过去，而junit是测试代码，不需要被拷贝到服务器中，
 * 所以不用maven导包也可。
 */
public class JDBC01 {

	/**
	 * 创建连接
	 */
	@Test
	public void test1() {
		System.out.println(1);
		// 注册驱动---oracle.ojdbc.Driver.oracleDriver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 创建连接
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.86.30.150:1521:orcl", "openlab",
					"open123");
			System.err.println(conn);
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用Properties读取db.properties文件 Properties是一个专门用来读取properties文件的Map集
	 */
	@Test
	public void test2() {
		System.out.println(2);
		Properties p = new Properties();
		try {
			// 从编译路径（classes）下读取文件
			p.load(JDBC01.class.getClassLoader().getResourceAsStream("db.properties"));
			String driver = p.getProperty("driver");
			System.out.println(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试DBTool
	 */
	@Test
	public void test3() {
		System.out.println(3);
		Connection conn = null;
		try {
			conn = DBTool.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTool.close(conn);
		}
	}

	/**
	 * 执行insert语句
	 */
	@Test
	public void test4() {
		Connection conn = null;
		try {
			conn = DBTool.getConnection();
			Statement smt = conn.createStatement();
			String sql = "insert into emps_Amb values(" + "emps_seq_Amb.nextval,'唐僧','总监',0"
					+ ",sysdate,8000.0,6000.0,2)";
			// 返回sql所能影响（增删改）的行数
			// 该方法在执行完sql后会自动commit
			int rows = smt.executeUpdate(sql);
			System.out.println(rows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTool.close(conn);
		}
	}

	/**
	 * 执行select语句
	 */
	@Test
	public void test5() {
		Connection conn = null;
		try {
			conn = DBTool.getConnection();
			Statement smt = conn.createStatement();
			String sql = "select * from emps_Amb " + "where sal>6000";
			// 返回结果集，内部封装了查询到的所有数据，
			// 它内部包含了多行多列数据.
			ResultSet rs = smt.executeQuery(sql);
			// 结果集采用Iterator模式设计而成，通常采用while遍历
			while (rs.next()) {
				// 每次next（）就可以从rs中获取一行数据，而每行包含多列，调用get（）获取。
				System.out.println(rs.getInt("empno"));
				System.out.println(rs.getString("ename"));
			}
			// System.out.println(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTool.close(conn);
		}
	}

	@Test
	public void test6() {
		Connection conn = null;
		try {
			conn = DBTool.getConnection();
			Statement smt = conn.createStatement();
			String sql = "update emps_Amb set ename='唐三藏' " + "where deptno=1";
			int rows = smt.executeUpdate(sql);
			System.out.println(rows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTool.close(conn);
		}
	}

	@Test
	public void test7() {
		Connection conn = null;
		try {
			conn = DBTool.getConnection();
			Statement smt = conn.createStatement();
			String sql = "delete emps_Amb where ename='唐三藏'";
			// ResultSet rs =smt.executeQuery(sql);
			// while(rs.next()){
			// System.out.println(rs.getInt("empno"));
			// System.out.println(rs.getString("ename"));
			// }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTool.close(conn);
		}
	}

}
