package AmbroseRen.method;

/**
 * 字符串支持正则表达式二：
 * String[] split(Stirng regex)
 * 将当前字符串按给定正则表达式满足的部分进行拆分
 * 将拆分的部分内容存入一个字符串数组并返回
 * 
 *
 */
public class String_split {

	public static void main(String[] args) {
		String str ="abc123def456ghi789jkl1111m ";
		String[] dates =str.split("\\d+");
//		System.out.println(dates);
		System.out.println(dates.length);
		for(int i=0;i<dates.length;i++){
			System.out.println(dates[i]);
		}
		/*-----test----*/
		String imgName ="133.jpg";
		String[] Names =imgName.split("\\.");
		//已经声明
		 imgName =System.currentTimeMillis()+"."+Names[1];
		 System.out.println(imgName);
	}

}
