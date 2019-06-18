package AmbroseRen.method;

/**
 * 测试Point重写Object的相关方法
 * @author 天大java
 *
 */
public class TestPoint {
	public static void main(String[] args) {
		Point p =new Point();
		p.setX(1);
		p.setY(2);
		/**
		 * Object定义了toString方法，该方法返回当前对象的句柄
		 * 即：类名@地址
		 * 用toString时，该重写该方法，返回更有意义的字符串
		 */
		String str =p.toString();
		System.out.println(str);
		/**
		 * System.out.println(Object o)
		 * 该方法输出给定对象toString返回的字符串到控制台
		 */
//		System.out.println(p.toString());
		
		Point p2 =new Point();
		p2.setX(1);
		p2.setY(2);
		System.out.println(p2);
		System.out.println(p==p2);
		System.out.println(p.equals(p2));
	}

}

