package AmbroseRen.method;

public class String_charAt {
	
	/**
	 * 取指定位置的字符,检测字符
	 * @param args
	 */
	public static void main(String[] args) {
		String str ="think in java";
		char c =str.charAt(4);
		System.out.println(c);
		
		String in ="天连水尾水连天";
		for(int i=0;i<in.length();i++){
			if(in.charAt(i) !=in.charAt(in.length()-1-i)){
				System.out.println("不是回文");
				return;//方法返回
				
			}
		}
		System.out.println("是回文");
	}
	
}
