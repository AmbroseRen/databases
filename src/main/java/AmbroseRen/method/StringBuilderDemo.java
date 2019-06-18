package AmbroseRen.method;

public class StringBuilderDemo {
	
	public static void main(String[] args) {
		String str ="String";
		StringBuilder sb =new StringBuilder(str);
		
		//追加
		StringBuilder str1 = sb.append("AAA");
		System.out.println(str1);
		
		//替换
		String str2 = sb.replace(2, 3, "000").toString();
		System.out.println(str2);
		
		//删除
		String str3 = sb.delete(2, 4).toString();
		System.out.println(str3);
		
		//插入
		String str4 = sb.insert(0, "BBB").toString();
		System.out.println(str4);
		
		//反转
		String str5 = sb.reverse().toString();
		System.out.println(str5);
		
	}
	
}
