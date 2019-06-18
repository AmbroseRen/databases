package AmbroseRen.arithmetic;

/**
 * 1.转换说明符
 *     %c             字符
 *     %d             有符号十进制整数
*      %f              浮点数(包括float和doulbe)
*     %a(%A)    	 浮点数、十六进制数字和p-(P-)记数法(C99)
*      %e(%E)    	 浮点数指数输出[e-(E-)记数法]		9.38e+5
*     %g(%G)		 通用浮点类型（f和e类型中较短的）
*      %g(%G)     浮点数不显无意义的零"0"
*      %i              有符号十进制整数(与%d相同)
*      %u             无符号十进制整数
*      %o             八进制整数    e.g.     0123
*      %x(%X)      十六进制整数0f(0F)   e.g.   0x1234
*      %#x			 带16进制（0x）前缀
*      %p             指针
*      %s             字符串
*      %%            "%"百分比
*      %h			散列码
*      %n			换行符
*      %tx			日期与时间类型
*      
* 2.标志
*      左对齐："-"   e.g.   "%-20s"
*      右对齐："+"  e.g.   "%+20s"
*      空格：若符号为正，则显示空格，负则显示"-"   e.g.   "%  6.2f"      
*      #：对c,s,d,u类无影响；对o类，在输出时加前缀o；对x类，在输出时加前缀0x；
*           对e,g,f 类当结果有小数时才给出小数点。
*           
*3.格式字符串（格式）
*      〔标志〕〔输出最少宽度〕〔．精度〕〔长度〕类型
*     "％-md" ：左对齐，若m比实际少时，按实际输出。
*     "%m.ns"：输出m位，取字符串(左起)n位，左补空格，当n>m or m省略时m=n
*                      e.g.    "%7.2s"   输入CHINA
*                                             输出"     CH"
*     "%m.nf"：输出浮点数，m为宽度，n为小数点右边数位
*                      e.g.    "%3.1f"    输入3852.99
*                                               输出3853.0 
*      长度：为h短整形量,l为长整形量
*   
* 项目名称：AmbroseRen  
* 类名称：printf  
* 类描述：  
* 创建人：Administrator  
* 创建时间：2018年12月12日 上午9:06:57  
* @version
 */
public class printf {
	public static void main(String[] args) {
		double d = 345.678;
		String s = "你好！";
		int i = 1234;
		// "%"表示进行格式化输出，"%"之后的内容为格式的定义。
		System.out.printf("%f", d);// "f"表示格式化输出浮点数。
		System.out.println();
		System.out.printf("%15.8f", d);// "9.2"中的9表示输出的长度，2表示小数点后的位数。
		System.out.println();
		System.out.printf("%+9.2f", d);// "+"表示输出的数带正负号。
		System.out.println();
		System.out.printf("%-9.4f", d);// "-"表示输出的数左对齐（默认为右对齐）。
		System.out.println();
		System.out.printf("%+-9.3f", d);// "+-"表示输出的数带正负号且左对齐。
		System.out.println();
		System.out.printf("%d", i);// "d"表示输出十进制整数。
		System.out.println();
		System.out.printf("%o", i);// "o"表示输出八进制整数。
		System.out.println();
		System.out.printf("%x", i);// "d"表示输出十六进制整数。
		System.out.println();
		System.out.printf("%#x", i);// "d"表示输出带有十六进制标志的整数。
		System.out.println();
		System.out.printf("%s", s);// "d"表示输出字符串。
		System.out.println();
		System.out.printf("输出一个浮点数：%f，一个整数：%d，一个字符串：%s", d, i, s);
		// 可以输出多个变量，注意顺序。
		System.out.println();
		System.out.printf("字符串：%2$s，%1$d的十六进制数：%1$#x", i, s);
		// "X$"表示第几个变量。
	}
}
