package AmbroseRen.network.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	private static BasicDataSource ds;// 建连接池声明

	static {
		Properties p = new Properties();
		try {
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			// 获取参数
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pwd = p.getProperty("pwd");
			String initSize = p.getProperty("initialSize");
			String maxSize = p.getProperty("maxActive");
			// 创建连接池
			ds = new BasicDataSource();
			// 设置参数 setParameter---------------
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			ds.setInitialSize(Integer.parseInt(initSize));
			ds.setMaxActive(Integer.parseInt(maxSize));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("加载db.properties失败！", e);
		}
	}

	/**
	 * 由连接池创建的连接，其实现类由连接池提供
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	/**
	 * 连接池提供的实现类，其close（）内部逻辑是： 将连接归还给连接池，即它会清空连接对象中的数据， 且将连接标记为空闲态。
	 */
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("归还连接失败！", e);
			}
		}
	}
	
	public static void rollback(Connection conn){
		if(conn !=null){
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
//				DBUtil.rollback(conn);
				throw new RuntimeException("回滚失败！",e);
			}
		}
	}

}