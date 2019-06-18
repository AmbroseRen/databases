package AmbroseRen.kit.Xml;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import AmbroseRen.kit.Xml.Emp;

/**
 * 使用DOM解析并读取文档
 * @author 天大java
 *
 */
public class ParseXMLDemo {
	public static void main(String[] args) {
		/**
		 * 解析XML的大致步骤
		 * 1.创建SAXReader
		 * 2.使用SAXReader读取XML文档并生成Document对象
		 * 这一步就是DOM解析耗时耗资源的地方，
		 * 应为要先将XML文档全部读取并转换为一个Document文档对象保存到内存。
		 * 3.通过Document获取根元素
		 * 4.通过根元素按照XML的逐级结构获取子元素以达到遍历XML文档数据的目的
		 */
		try {
			SAXReader sr =new SAXReader();
			Document doc =sr.read(new FileInputStream("emplist.xml"));
			/**
			 * 将emplist.xml文档中的所有员工信息读取出来并以若干Emp实例存入一个集合
			 * 将来可供java使用
			 */
			/**
			 *Element的每个实例用于表示文档中的每一对标签。
			 *Element页提供了获取标签相关的方法： 
			 *
			 *List element（String name）获取指定子元素
			 *List elements（）获取所有子元素
			 *List elements（String name）获取同名子元素
			 *
			 *String getText（）
			 *获取元素中间的文本(开始标签与结束标签中间的文本信息)
			 *
			 *String elementText(String name)
			 *获取当前元素中指定名字子元素中间的文本
			 *例如：  
			 *ele.element（“xx”）.getText（）
			 *等同于：
			 *ele.elementText（“xx”）
			 *
			 *Attribute Attribute（String name）
			 *获取当前元素中指定名字的属性
			 */
			Element root =doc.getRootElement();
			/**
			 * 创建集合保存从xml文档中读取出来的所有员工信息
			 */
			List<Emp> emplist =new ArrayList<Emp>();
//			获取<list>子标签
			List<Element> list =root.elements();
			
			for(Element empEle:list){
				//获取首标签
				String name =empEle.getName();
				System.out.println("name=="+name);
				
//				获取名字
				Element nameEle =empEle.element("name");
				String name1 =nameEle.getText();
				System.out.println("name1=="+name1);
				
				Element ageEle =empEle.element("age");
				int age =Integer.parseInt(ageEle.getText());
				System.out.println(age);
				
//				获取性别
				Element genderEle =empEle.element("gender");
				String gender =empEle.getText();
//				String gender =empEle.elementText("gender");
				System.out.println(gender);
				
				int salary =Integer.parseInt(
						empEle.elementText("salary"));
				System.out.println(salary);
				
				/**
				 * 获取属性：id
				 * Attribute的每个实例用于表示一个属性
				 * 常用方法：
				 * String getName（）：获取属性名
				 * String getValue（）：获取属性值
				 */
				Attribute att =empEle.attribute("id");
				int id =Integer.parseInt(att.getValue());
				System.out.println("id=="+id);
				
				Emp emp =new Emp(id, name, age, gender, salary);
				emplist.add(emp);	
			}
			
			System.out.println("解析完毕！");
			for(Emp e:emplist){
//				System.out.println(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
