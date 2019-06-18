package AmbroseRen.method;

/**
 * 自动包装
 * java的8个基本类型分别定义了8个包装类
 * 在面向对象与基本类型之间自由转换
 * @author 天大java
 *
 */
public class IntegerDemo1 {
	public static void main(String[] args) {
		/*包装=向上造型*/
		int a=0;
		double b =0.0;
		//建了新的栈堆
		Integer a1 =new Integer(a);
		/*简便方法*/
		Integer a2 =Integer.valueOf(a);
		System.out.println(a1==a2);//栈的比较必不一样
		System.out.println(a1.equals(a2));
		
		//Double的valueof是直接new的
		Double b1 =new Double(b);
		Double b2 =Double.valueOf(b);
		
		//拆为基本类型取返回值
		double d =b1.doubleValue();
		System.out.println(d);
		
		float f =b1.floatValue();
		System.out.println(f);
		
		int i =b1.intValue();
		System.out.println(i);
	}
}
