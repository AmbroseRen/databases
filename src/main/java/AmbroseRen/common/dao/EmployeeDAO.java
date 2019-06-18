package AmbroseRen.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AmbroseRen.common.entity.Employee;
import AmbroseRen.network.JDBC.DBUtil;

public class EmployeeDAO {
	public void save(Employee e){
		Connection conn =null;
		try {
			conn =DBUtil.getConnection();
			String sql ="INSERT INTO t_emp_Amb VALUES(t_emp_seq_Amb.nextval,?,?,?)";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, e.getEname());
			ps.setDouble(2, e.getSalary());
			ps.setInt(3, e.getAge());
			ps.executeUpdate();
		} catch (SQLException e2) {
			//1)记日志（保留现场）
			e2.printStackTrace();
			/**
			 * 2)看异常能否恢复，
			 * 如不能恢复（如：数据库服务暂停等，一般称之为系统异常）， 要提示用户稍后重试.
			 * 如能恢复，则立即恢复
			 */
			throw new RuntimeException(e2);
		}
	}
	public List<Employee> findAll(){	
		List<Employee> employees =new ArrayList<Employee>();
		Connection conn =null;
			try {
				conn =DBUtil.getConnection();
				String sql ="select * from t_emp_Amb";
				PreparedStatement ps =conn.prepareStatement(sql);
				//添加到集合里--------------
				ResultSet rs =ps.executeQuery();
				while(rs.next()){					
					Employee e =new Employee(); 
					e.setId(rs.getInt("ID"));
					e.setEname(rs.getString("ename"));
					e.setSalary(rs.getDouble("salary"));
					e.setAge(rs.getInt("age"));
					employees.add(e);
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("添加失败...");
			}finally{
				DBUtil.close(conn);
			}
		return employees;
	}
	public void delete(int id){
		Connection conn=null;
		try {
			conn =DBUtil.getConnection();
			String sql ="delete from t_emp_Amb where id=?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
			System.out.println("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);			
		}
	}
	public Employee findById(int id){
		Connection conn =null;
		try {
			conn =DBUtil.getConnection();
			String sql ="select * from t_emp_Amb where id=?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs =ps.executeQuery();
			if(rs.next()){
				Employee e =new Employee();
				e.setId(id);
				e.setEname(rs.getString("ename"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}
	public Employee update(Employee e){
		Connection conn =null;
		try {
			conn =DBUtil.getConnection();
			String sql ="update t_emp_Amb set ename=?,salary=?,age=? where id=?";
			PreparedStatement ps =conn.prepareStatement(sql);
			//Employee e =new Employee();
			ps.setInt(4,e.getId());
			ps.setString(1, e.getEname());
			ps.setDouble(2, e.getSalary());
			ps.setInt(3, e.getAge());
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("修改失败");
		}finally{
			DBUtil.close(conn);
		}
		return e;
	}
}
