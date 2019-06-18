package AmbroseRen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import AmbroseRen.dao.impl.UserDAO;
import AmbroseRen.entity.User;
/**
 *持久层实现类
 */
//@Repository("userDAO")
public class UserDAOJdbcImpl implements UserDAO{
	@Resource(name="db")
	private DataSource ds;
	public User findByUsername(String uname){
		User user =null;
		Connection conn =null;
		try {
			conn =ds.getConnection();
			String sql ="select * from ambrose where uname=?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs =ps.executeQuery();
			if(rs.next()){
				user =new User();
				user.setId(rs.getInt("id"));
				user.setUname(uname);
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setSex(rs.getString("sex"));
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			if(conn !=null){
				try {
					conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
					throw new RuntimeException();
				}
			}
		}
		return user;
	}
}
