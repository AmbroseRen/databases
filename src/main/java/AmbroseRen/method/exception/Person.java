package AmbroseRen.method.exception;

import java.io.Serializable;
import java.util.List;

/**
 * 测试对象进行的读写操作，
 * 类的实例被对象流读写，必须实现Serializable接口
*   
* 项目名称：AmbroseRen  
* 类名称：Person  
* 类描述：  
* 创建人：Administrator  
* 创建时间：2018年12月10日 上午11:39:44  
* @version
 */
public class Person implements Serializable{

	private static final long serialVersionUID = -8557352356828846795L;

	private String name;
	private int age;
	private String gender;
	
	private List<String> otherInfo;

	public Person() {
		super();
	}
	
	public Person(String name, int age, String gender, List<String> otherInfo) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.otherInfo = otherInfo;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(List<String> otherInfo) {
		this.otherInfo = otherInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", otherInfo=" + otherInfo + "]";
	}
	
	
}
