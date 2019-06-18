package AmbroseRen.method.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 计算到今天的天数
 */
public class Test {
	
	public static void main(String[] args) throws ParseException {
		Scanner sr =new Scanner(System.in);
		System.out.println("请输入自己的生日:格式为(1992-02-02)");
		String str =sr.nextLine();

		//将生日转换为日期格式！！！！！！
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		Date date =sdf.parse(str);

		Date now =new Date();
		System.out.println(now.getTime());
		//.getTime()获得毫秒数
		Long time =now.getTime()-date.getTime();
		long day =time/1000/60/60/24;
		System.out.println(day+"天");
		
		if(day>10000){
			System.out.println("你已经活了一万多天了");
		}
		
		
	}
	
}
