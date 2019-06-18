package AmbroseRen.method.byteStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import AmbroseRen.method.exception.Person;

/**
 * 对象输入流
 * 用于反序列化对象------有问题
 */
public class ObjectInputStream_readObject {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis =new FileInputStream("两极.txt");
		/**
		 * 输入并强转
		 */
		ObjectInputStream ois =new ObjectInputStream(fis);
		Person p =(Person)ois.readObject();
		System.out.println(p);
		ois.close();
	}
}

