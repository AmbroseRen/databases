package AmbroseRen.method;

import java.util.Scanner;

/**
 * 字符串支持正则表达式的方法一：
 * boolean matches(String regrex)
 * 用给定的正则表达式验证验证当前字符串是否满足格式要求
 * 全匹配边界符（^……$）
 * 不加则部分匹配
 * 
 *
 */
public class String_matches {
	/*^[a-zA-Z0-9_]+@[a-zA-Z0-9]+([\.[a-zA-Z0-9]+])+$*/
	public static void  main(String[] args){
		Scanner sc =new Scanner(System.in);
		System.out.println("请输入邮箱地址：");
		String email =sc.nextLine();
		//10000@qq.com.cn
		//String regex ="^[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)+";
//		String regex ="[\\w]+@[\\w]+[\\.\\w]+";
		String regex ="^[0-9]+$";
//		String regex ="^\\d+$";
//		String email ="Rensi@tedu.cn";
		boolean result =email.matches(regex);
//		boolean result =regex.matches(email);//错误写法
		if(result){
			System.out.println("是邮箱");
		}else{
			System.out.println("不是邮箱");
		}
	}
}