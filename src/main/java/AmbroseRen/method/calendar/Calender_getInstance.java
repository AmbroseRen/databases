package AmbroseRen.method.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Calendar
 * 日历类（抽象类），定义了相关常量及日历相关操作方法
 * 常用实现类：GregorianCalender即：日历
 * 
 * Calendar提供了一个静态方法：getInstance，
 * 该方法可以根据当前系统所在地区获取一个适用的实现类
 *
 */
public class Calender_getInstance {

	public static void main(String[] args) {
		//默认当前系统时间
		Calendar calendar =Calendar.getInstance();
		System.out.println(calendar);	
		/**
		 * 将Calendar表示的日期用date形式表示
		 * Calendar方法： Date getTime（）
		 */
		Date date =calendar.getTime();
//		Date da =new Date();
//		System.out.println(da);
		System.out.println(date);
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("中文时间"+sdf.format(date));
		
		//.setTime()获取Calendar的真值（逆向获取）
		calendar.setTime(date);
		System.out.println(calendar);
		
	}
	
}

