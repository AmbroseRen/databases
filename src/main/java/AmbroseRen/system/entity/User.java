package AmbroseRen.system.entity;

import java.util.Arrays;

public class User {
	private String name;
	private int age;
	private String[] interest;
	private String gender;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getInterest() {
		return interest;
	}
	public void setInterest(String[] interest) {
		this.interest = interest;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", interest=" + Arrays.toString(interest) + ", gneder=" + gender
				+ "]";
	}
	
}
