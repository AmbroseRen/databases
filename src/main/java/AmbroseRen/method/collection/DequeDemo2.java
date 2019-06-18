package AmbroseRen.method.collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 * 栈可存储一组元素
 * （但必须先进后出）
 * @author 天大java
 *
 */
public class DequeDemo2 {

	public static void main(String[] args) {
		Deque<String> deque =new LinkedList<String>();
		deque.push("one");
		deque.push("two");
		deque.push("three");
		deque.push("four");
		System.out.println(deque);
		
		String str =deque.pop();
		System.out.println(deque);
		
		for(String s:deque){
			System.out.println(s);
		}
		System.out.println("------------");
		while(deque.size()>0){
			deque.pop();
			System.out.println(deque);
		}
	}

}
