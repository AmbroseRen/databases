package AmbroseRen.method;

/**
 * String replaceAll(String regex,String String)
 * 将给定字符串中满足正则表达式的部分替换为指定字符串
 *
 */
public class String_replaceAll {

	public static void main(String[] args) {
		String str = "abc123def456ghi789jkl1111m";
		/*替换数字为：@ */
//		str =str.replaceAll("\\d","@");
//		System.out.println(str);	
		str =str.replaceAll("[a-zA-Z]+","&");
		System.out.println(str);

		/*-----test-----*/
		String regex ="(wqnmlgb|sb|mdzz|cnm|ctm|lj)";
		String message ="wqnmlgb!你这个sb！你怎么这么lj";
		message =message.replaceAll(regex, "煞笔");
		System.out.println(message);
	}

}