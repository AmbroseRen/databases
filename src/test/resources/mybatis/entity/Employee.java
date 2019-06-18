package entity;

public class Employee {
	private int id;
	private String dept_name;
	private String loc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", dept_name=" + dept_name + ", loc=" + loc + "]";
	}
	
}
