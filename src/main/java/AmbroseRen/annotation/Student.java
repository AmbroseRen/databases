package AmbroseRen.annotation;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Required;

public class Student {
	private String name;
	private int age;
	private List<String> interest;
	private Set<String> city;
	private Map<String,Double> score;
	private Properties db;
	
	public Student() {
		System.out.println("Student()对象开始注入");
	}
	/**
	 * 容器会调用此方法来注入基本类型的值
	 */
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public List<String> getInterest() {
		return interest;
	}
	public Set<String> getCity() {
		return city;
	}
	public Map<String, Double> getScore() {
		return score;
	}
	public Properties getDb() {
		return db;
	}
	
	@Required
	public void setName(String name) {
		System.out.println("setName()"+name);
		this.name = name;
	}
	public void setAge(int age) {
		System.out.println("setAge()"+age);
		this.age = age;
	}
	public void setInterest(List<String> interest) {
		System.out.println("setInterest(List<String>)");
		this.interest = interest;
	}
	public void setCity(Set<String> city) {
		System.out.println("setCity(Set<String>)");
		this.city = city;
	}
	public void setScore(Map<String, Double> score) {
		System.out.println("setScore(Map<String,Double>)");
		this.score = score;
	}
	public void setDb(Properties db) {
		System.out.println("setDB(Properties)");
		this.db = db;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", interest=" + interest + ", city=" + city + ", score="
				+ score + ", db=" + db + "]";
	}
	
}
