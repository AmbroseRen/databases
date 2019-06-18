package AmbroseRen.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import AmbroseRen.dao.impl.EmployeeDAO.EmpRowMapper;
import AmbroseRen.entity.Employee;

@Repository("empDAO")
public class EmployeeDAO {
	@Autowired
	@Qualifier("jt")
	private JdbcTemplate jt;
	
	public void save(Employee e){
		String sql ="insert into t_emp_Amb values(t_emp_amb_seq.nextval,?,?,?)";
		Object[] args ={e.getEname(),e.getSalary(),e.getAge()};
		jt.update(sql,args);
	}
	public Employee findById(int id){
		String sql ="select * from t_emp_amb where id=?"; 
		Object[] arg ={id};
		Employee e ;
		try {
			e =jt.queryForObject(sql, arg,new EmpRowMapper());
		} catch (EmptyResultDataAccessException e2) {
			return null;
		}
		return e ;
	}
	
	public List<Employee> findAll(){
		String sql ="select *　from t_emp_Amb";
		List<Employee> employees =jt.query(sql,new EmpRowMapper());
		return employees;
	}
	
	public void update(Employee e){
		String sql ="update t_emp_amb set ename=?,salary=?,age=? where id=?";
		Object[] obj ={e.getEname(),e.getSalary(),e.getAge(),e.getId()};
		jt.update(sql,obj);
	}
	public void delete(int id){
		String sql ="delete from t_emp_amb where id=?";
		Object[] arg ={id};
		jt.update(sql,arg);
	}
	/**
	 * 如何将记录转换成一个对象
	 */
	class EmpRowMapper implements RowMapper<Employee>{
		//arg1：正在被处理的记录的下标。
		public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
			Employee e =new Employee();
			e.setId(rs.getInt("id"));
			e.setEname(rs.getString("ename"));
			e.setSalary(rs.getDouble("salary"));
			e.setAge(rs.getInt("age"));
			return e;
		}
		
	}
}
