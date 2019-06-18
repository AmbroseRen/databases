package AmbroseRen.method.calendar;

import java.util.Calendar;

/**
 * void set(int field,int value)
 * 对指定时间分量获取给定的值
 * @author 天大java
 *
 */
public class Calendar_set {

	public static void main(String[] args) {
		Calendar calendar =Calendar.getInstance();
		/*calendar.set(Calendar.YEAR,2008);
		calendar.set(Calendar.MONTH,7);*/
		calendar.set(2008, 6, 25);
		System.out.println(calendar.getTime());
		
		//获取周三的时间
		calendar.set(Calendar.DAY_OF_WEEK,3);
		System.out.println(calendar.getTime());
	}

}