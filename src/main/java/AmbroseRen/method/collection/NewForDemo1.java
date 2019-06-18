package AmbroseRen.method.collection;

/**
 * 增强For循环，又称新循环，for each
 * 它自JDK1.5以后推出的新特性
 * 新循环只用来遍历集合或数组
 *
 */
public class NewForDemo1 {

	public static void main(String[] args) {
		String[] array ={"one","two","three","four","five"};
		for(int i=0;i<array.length;i++){
			String str =array[i];
			System.out.println(str);
		}
		
//		for(String str:array){
//			System.out.println(str);
//		}

	}

}

