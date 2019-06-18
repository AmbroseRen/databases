package AmbroseRen.method.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.SimpleDateFormat
 * 该类可以按给定日期的格式将Date与String之间相互转换
 * @author 天大java
 *
 */
public class SimpleDateFormat_format {
	public static void main(String[] args) throws ParseException {
		Date now =new Date();
		System.out.println(now);
//		SimpleDateFormat sdf =new SimpleDateFormat("E HH:mm:ss MM-dd-yyyy");//yyyyMMddHHmmss
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/**
		 * |Date->String
		 * String format(Date date)
		 * 按照SimpleDateFormat指定的日期格式
		 * 将给定的英文Time转换为 中文 字符串时间
		 */
		//.format()转换为中文时间
		String str =sdf.format(now);
		System.out.println(str);
	}

}