package AmbroseRen.method.collection;

import java.util.Iterator;
import java.util.TreeSet;

public class Set_TreeSet {

	//无法对TreeSet进行Iterator迭代
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("ccc");
		ts.add("aaa");
		ts.add("ddd");
		ts.add("bbb");
//		Iterable<String> iterable =(Iterable<String>) ts.iterator();
//		Iterator<String> iterator = (Iterator<String>) iterable;
//		while (iterator.hasNext()) {
//			iterable.
//		}
 
		System.out.println(ts); // [aaa, bbb, ccc, ddd]

	}

}
