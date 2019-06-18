package AmbroseRen.method.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户输入自己的生日，然后输出其生日当天是当年的第几天以及星期几？
 *
 */
public class Test2 {

	public static void main(String[] args) throws ParseException {
		Scanner sc =new Scanner(System.in);
		System.out.println("请输入您的生日日期：");
		String str =sc.nextLine();
		
		SimpleDateFormat sdf =new SimpleDateFormat("MM-dd-yyyy");
		Date birth =sdf.parse(str);
		System.out.println("birth:"+birth);
		//.setTime()逆向获取时间字符串
		Calendar calendar =Calendar.getInstance();
		calendar.setTime(birth);
		//查看是当年的第几天
		int days =calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println(days);
		
		int week =calendar.get(Calendar.DAY_OF_WEEK);
		String[] date ={"日","一","二","三","四","五","六"};
		System.out.println("那一天是星期"+date[week]);

	}

}
