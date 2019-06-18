package AmbroseRen.network.JDBC;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import AmbroseRen.network.JDBC.Emp;
import AmbroseRen.network.JDBC.DBUtil;

public class EmpDao implements Serializable {
	
	private static final long serialVersionUID = 280252131825277436L;

	/*增加一个员工*/
	public void save(Emp e){//?????
		Connection conn =null;
		try {
			conn =DBUtil.getConnection();
			Statement smt =conn.createStatement();
			String sql = "insert into emps_Amb "
					+ "values("+"emps_seq_Amb.nextval,'?','?',?,sysdate,?,?,?)";
			int rows =smt.executeUpdate(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}
	
	/*根据ID修改员工的其他字段*/
	public void update(Emp e){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update emps_Amb set "
					+ "ename=?,"
					+ "job=?,"
					+ "mgr=?,"
					+ "hiredate=?,"
					+ "sal=?,"
					+ "comm=?,"
					+ "deptno=? "
					+ "where empno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getEname());
			ps.setString(2, e.getJob());
			ps.setInt(3, e.getMgr());
			ps.setDate(4, e.getHiredate());
			ps.setDouble(5, e.getSal());
			ps.setDouble(6, e.getComm());
			ps.setInt(7, e.getDeptno());
			ps.setInt(8, e.getEmpno());
			ps.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException("修改员工失败！",e1);
		}finally{
			DBUtil.close(conn);
		}
	}
	
	/*根据ID删除员工*/
	public void delete(int id){//????
		Connection conn =null;
		try {
			conn =DBUtil.getConnection();
			Statement smt =conn.createStatement();
			String sql = "delete from emps_Amb where empno=?";
//			PreparedStatement ps =conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	
	/*根据ID查询一个员工*/
	public Emp findById(int id){
		Connection conn =null;
		try {
			conn =DBUtil.getConnection();
			String sql = "select *　from emps_Amb where empno=?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs =ps.executeQuery();
			if(rs.next()){				
//				  Alt+Shift+M	封装createEmp（）-----------				 		
				Emp e = createEmp(rs);
				
				return e;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询员工失败！",e);
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}

//	复用封装的方法
	private Emp createEmp(ResultSet rs) throws SQLException {
		Emp e =new Emp();//防止结果集清空
		e.setEmpno(rs.getInt("empno"));
		e.setEname(rs.getString("ename"));
		e.setJob(rs.getString("job"));
		e.setMgr(rs.getInt("mgr"));
		e.setHiredate(rs.getDate("hiredate"));
		e.setSal(rs.getDouble("sal"));
		e.setComm(rs.getDouble("comm"));
		e.setDeptno(rs.getInt("deptno"));
		return e;
	}
	
	/*查询所有员工*/
	public List<Emp> findAll(){//???
		
		return null;
	}
	
	/*分页查询员工*/
	public List<Emp> findByPage(int page,int size){
		Connection conn =null;
		try {
			conn =DBUtil.getConnection();
			String sql = "select * from (select rownum rn,"
					+ "e.* from(select * from emps_Amb order by empno) e) "
					+ "where rn between ? and ?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*size+1);
			ps.setInt(2, page*size);
			ResultSet rs =ps.executeQuery();
			
			List<Emp> list =new ArrayList<Emp>();
			while(rs.next()){
				Emp e =createEmp(rs);
				list.add(e);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询员工失败！",e);
		}finally{
			DBUtil.close(conn);
		}
	}
	
}
