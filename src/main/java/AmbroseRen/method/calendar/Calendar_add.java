package AmbroseRen.method.calendar;

import java.util.Calendar;

/**
 * void aa(int field,int value)
 * 对指定时间分量加上给定的值，若给定的值为负数则减去。
 *
 */
public class Calendar_add {

	public static void main(String[] args) {
		Calendar calendar =Calendar.getInstance();
		System.out.println("+"+calendar);
		calendar.add(Calendar.YEAR,9000);
		calendar.add(Calendar.MARCH,2);
		calendar.add(Calendar.DAY_OF_YEAR,30);
		System.out.println(calendar.getTime());
		
		//设置当周的周数日期
		calendar.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
		System.out.println(calendar.getTime());
		
		//计算前N天
		calendar.set(Calendar.DAY_OF_YEAR,-3);
		System.out.println(calendar.getTime());
		
		int days =calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("当月月底是"+days+"号");
		//
	}

}
