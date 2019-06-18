package AmbroseRen.method.collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列
 * java.util.Deque
 * 双端队列继承自Queue接口
 * 常用实现类：java.util.LinkedList
 * 双端队列就是两端都可以做入队和出队操作
 *
 */
public class DequeDemo {

	public static void main(String[] args) {
		Deque<String> deque =new LinkedList<String>();
		deque.offer("one");
		deque.offer("two");
		deque.offer("three");
		deque.offer("four");
		System.out.println("元素为："+deque);
		
		deque.poll();
		System.out.println("抹掉首元素为："+deque);

		deque.offerLast("five");
		System.out.println("末尾添加："+deque);
		
		String f =deque.peekFirst();
		System.out.println("取首元素："+f);
	}

}

