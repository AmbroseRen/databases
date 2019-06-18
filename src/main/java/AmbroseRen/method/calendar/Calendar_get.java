package AmbroseRen.method.calendar;

import java.util.Calendar;

/**
 * Calendar提供了根据给定时间分量获取对应值的方法：
 * int get（int field）
 * 
 * 时间分量对应的是Calendar提供的相应常量。
 *
 */
public class Calendar_get {

	public static void main(String[] args) {
		/**
		 * 三个时间分量：YEAR+MONTH+DAY
		 * 天的时间分量：
		 * DAY_OF_MONTH:即月中的天
		 * DAY_OF_WEEK:即周中的天
		 * DAY_OF_YEAR:即年中的天
		 * DATE:与DATE_OF_MONTH意思一致
		 */
		Calendar calendar =Calendar.getInstance();
		int year =calendar.get(Calendar.YEAR);
		System.out.println("year:"+year);
		/**
		 * month从0月开始计算
		 */
		int month =calendar.get(Calendar.MONTH)+1;
		int day =calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(month+"-"+day+"-"+year);
		
		int h =calendar.get(Calendar.HOUR);
		int m =calendar.get(Calendar.MINUTE);
		int s =calendar.get(Calendar.SECOND);
		System.out.println(h+":"+m+":"+s);
//		System.out.println(+":"+);
		
		int week =calendar.get(Calendar.DAY_OF_WEEK);
		String[] date ={"日","一","二","三","四","五","六"};
		System.out.println(""+date[week]);

	}

}
