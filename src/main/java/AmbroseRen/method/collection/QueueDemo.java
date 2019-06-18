package AmbroseRen.method.collection;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue
 * 队列，存取元素必须遵循先进先出原则
 * 常用实现类：LinkList
 *
 */
public class QueueDemo {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		/**
		 * boolean offer（E e）
		 * 将给定元素进行“入列”操作，
		 * 将元素添加到队列末尾
		 */
		queue.offer("oen");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		System.out.println(queue);
		
		//.poll()从队首获取元素(首元素没了)
		String str =queue.poll();
		System.out.println(str);
		
		//.peek()引用队首元素
		str =queue.peek();
		System.out.println("peek:"+str);
		
		System.out.println("---------------------------");
		//迭代器遍历队列
		for(String s:queue){
			System.out.println(s);
		}
		System.out.println("迭代器遍历为："+queue);

		System.out.println("---------------------------");
		//自行遍历一次性的
		while(queue.size()>0){
			String e =queue.poll();
			System.out.println(e);
		}
		System.out.println("whlie遍历为："+queue);
	}

}
