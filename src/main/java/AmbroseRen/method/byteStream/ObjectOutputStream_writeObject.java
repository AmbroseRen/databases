package AmbroseRen.method.byteStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import AmbroseRen.method.exception.Person;

public class ObjectOutputStream_writeObject {
	public static void main(String[] args) throws IOException {
		Person p =new Person();
		p.setName("甲");
		p.setAge(10);
		p.setGender("女");
		List<String> otherInfo =new ArrayList<String>();
		otherInfo.add("测试1");
		otherInfo.add("测试2");
		otherInfo.add("测试3");
		p.setOtherInfo(otherInfo);
		byte[] data =new byte[1024*10];
		System.err.println(p);
		/**
		 * 建立文件流，并连接
		 */
		FileOutputStream fos =new FileOutputStream("两极.txt");
		ObjectOutputStream oos =new ObjectOutputStream(fos);
		/**
		 * 对象输出流方法：输出流.writeObject()
		 * 其将给定的对象转换为一组对应的字符串，通过对象输出流输出
		 * 
		 * 将对象转换为字节需要：
		 * 1.对象序列化：即将java对象按照其结构转化为一组字节的过程
		 * 2.持久化：将一组字节写入文件（硬盘）上的过程称为持久化
		 */
		oos.writeObject(p);
		System.out.println("输出完毕");
		oos.close();
	}
	
}
