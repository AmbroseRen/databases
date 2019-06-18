package AmbroseRen.method;

public class String_api {

	public static void main(String[] args) {
	//				  0123456789
		String str = "Thinking In Java是一本书";
//查找字符串位置
		int index = str.indexOf("in",3);
		System.out.println(index);
//大小写转换		
		String T = str.toUpperCase();
		System.out.println(T);
		
		String t = str.toLowerCase();
		System.out.println(t);
//截取字符串
		String s = str.substring(9,11);
		System.out.println(s);
		
		String sub = str.substring(5,8);
//截取后段String不要
		 sub = str.substring(5);
		System.out.println(sub);
//反转		
//		String v = str.reverse();
//查找下标字符		
		char look = str.charAt(7);
		System.out.println(look);
		
	
		
		String h = "天连水尾水连天";
		String print = "";
		System.out.println(h.toString());
		System.out.println();

		int f = str.indexOf("字符串位置");	

	}
	
}
