package AmbroseRen.kit.Xml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import AmbroseRen.kit.Xml.Emp;

/**
 * 使用DOM生成XML
 * 
 *
 */
public class WriteXMLDemo {

	public static void main(String[] args) {
		/**
		 * 生成XML文档的大致步骤：
		 * 1.创建一个Document对象
		 * 2.向Document中添加根元素
		 * 3.向根元素中逐级追加子元素以形成XML文档结构。
		 * 4：创建XmlWriter
		 * 5：通过XMLWrite写出Document对象以形成xml文档
		 * 6：关闭XMLWrite
		 */
		List<Emp> emplist =new ArrayList<Emp>();
		emplist.add(new Emp(1,"张三",22,"男",3000));
		emplist.add(new Emp(2,"李四",33,"男",4000));
		emplist.add(new Emp(3,"王五",33,"女",5000));
		emplist.add(new Emp(4,"赵六",33,"女",4000));
		emplist.add(new Emp(5,"钱七",33,"男",8000));
		emplist.add(new Emp(6,"钱七00000",33,"男",8000));
		
		Document doc =DocumentHelper.createDocument();
		/**
		 * Document提供添加元素的方法：
		 * Element addElement（String name）
		 * 添加给定名字的根元素，并将其以Element实例形式返回，以便基于
		 * 根元素继续追加操作。
		 * 只能调用一个一次，一个文档只能有一个root元素
		 */
		Element root =doc.addElement("list");
		
		/**
		 * 将集合中的每个实例以一个<Emp>标签的形式添加到根元素中
		 * 
		 * Element提供了向当前元素中添加信息的相关方法：
		 * 1：Element addElement（String name）
		 * 	向当前元素中添加给定名字的子元素，并将该子元素以一个Element实例形式返回，
		 * 	便于继续向子元素追加信息
		 * 
		 * 2：Element addText（String text）
		 * 	向当前元素添加文本，返回值为当前元素，便于对当前元素继续操作其他元素
		 * 
		 * 3：Element addAttribute（String name，String value）
		 * 	添加名字以及对应值
		 */
		for(Emp emp:emplist){
//			建立实例em集合p
			Element empEle =root.addElement("emp");
			
			Element nameEle =empEle.addElement("name");
			nameEle.addText(emp.getName());
			
			Element ageEle =empEle.addElement("age");
//						法二：String.valueOf
			ageEle.addText(Integer.toString(emp.getAge()));
			
			Element genderEle =empEle.addText("gender");
			genderEle.addText(emp.getGender());
			
			Element salaryEle =empEle.addText("salary");
			salaryEle.addText(String.valueOf(emp.getSalary()));
			
//			添加名字以及对应值
			empEle.addAttribute("id",emp.getId()+"");
		}
		
		XMLWriter writer =null;
		try {
			writer =new XMLWriter(
					new FileOutputStream("myemp2.xml"),
					OutputFormat.createPrettyPrint()
			);
			writer.write(doc);
			System.out.println("写出完毕");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(writer !=null){
				try {
					
					writer.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}
