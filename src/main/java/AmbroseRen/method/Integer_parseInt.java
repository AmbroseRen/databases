package AmbroseRen.method;

/**
 * 包装的静态方法：parseXXX(String str)
 * 可以将给定的字符串转换为 对应的 基本类型（前提是该字符串内容有保存值）
 * 编译器的 自动拆装箱 会补充代码自动 
 * 将基本类型与引用类型 进行转换！！！！！！
 *
 */
public class Integer_parseInt {

	public static void main(String[] args) {
		String s ="113242";
		System.out.println(s+1);
		int i =Integer.parseInt(s);
		System.out.println(i);
		
		double d =Double.parseDouble(s);
		System.out.println(d+1);
		
		float f =Float.parseFloat(s);
		System.out.println(":"+f);
		
		//XXX.valueof()|.parseXXX()向下造型
		int in =new Integer(342).intValue();
		System.out.println(in+1);
		Integer in1 =Integer.valueOf(in);
		System.out.println("in1:"+in1+1);
		
		System.out.println(Integer.valueOf(5) == Integer.valueOf(5));
//		Integer a =new Integer(600).valueOf(i);
		System.out.println(Integer.valueOf(500) == Integer.valueOf(500));
		System.out.println(Integer.valueOf(600) == Integer.valueOf(600));
	}

}
