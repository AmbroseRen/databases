package AmbroseRen.method.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将日期格式转换为：英文格式
 *
 */
public class SimpleDateFormat_parse {

	public static void main(String[] args) throws ParseException {
		//将日期格式转换为：英文格式
		String str ="20:08:08 08-08-2008";
		SimpleDateFormat sdf =new SimpleDateFormat("HH:mm:ss MM-dd-yyyy");
		/**
		 * |String->Date
		 * Date date(String format)
		 * 按照SimpleDateFormat指定的日期格式
		 * 将给定的 中文 字符串转时间转换为英文Time
		 */
		//.parse（）转换为英文Time
		Date date =sdf.parse(str);
		System.out.println(date);
	}

}