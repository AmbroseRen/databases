package AmbroseRen.arithmetic;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**  
*   
* 项目名称：AmbroseRen  
* 类名称：Arith  
* 类描述：  
* 创建人：Administrator  
* 创建时间：2018年12月11日 上午10:25:02  
* @version       
*/ 
public class Arith {
	/**
	 * 提供精确加法计算的add方法
	 * @param value1 被加数
	 * @param value2 加数
	 * @return 两个参数的和
	 */
	public static double add(double value1,double value2){
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		return b1.add(b2).doubleValue();
	}
	/**
	 * 提供精确减法运算的sub方法
	 * @param value1 被减数
	 * @param value2 减数
	 * @return 两个参数的差
	 */
	public static double sub(double value1,double value2){
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确乘法运算的mul方法
	 * @param value1 被乘数
	 * @param value2 乘数
	 * @return 两个参数的积
	 */
	//法一：返回科学计数法值
	public static double mul(double value1,double value2){
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		return b1.multiply(b2).doubleValue();
	}
	//法二：返回精度值
	public static String mul(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return numFormat(b1.multiply(b2).toString());
	}	
	
	private static String numFormat(String resultFormat) {
		String d = resultFormat;
		if (d.contains(".")) {
			String dot=d.substring(d.indexOf("."), d.length());
			DecimalFormat df = new DecimalFormat("#.####################");
			//不用指定整数位多少位，这样比较好，以免数很大造成科学计数法
			double db=Double.valueOf(dot);
			String str=df.format(db);
			str=d.substring(0, d.indexOf("."))+str.substring(1, str.length());
			//System.out.println(str);
			return str;
		}
		return d;
	}
	
	/**
	 * 提供精确的除法运算方法div
	 * @param value1 被除数
	 * @param value2 除数
	 * @param scale 精确范围
	 * @return 两个参数的商
	 * @throws IllegalAccessException
	 */
	public static double div(double value1,double value2,int scale) throws IllegalAccessException{
		//如果精确范围小于0，抛出异常信息
		if(scale<0){
			throw new IllegalAccessException("精确度不能小于0");
		}
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		return b1.divide(b2, scale,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * double数精度截取
	 * @param d1
	 * @param n
	 * @return
	 */
	public static Double dob(Double d1,int n) {
		BigDecimal bigDecimal=new BigDecimal(d1);
		double d2 =bigDecimal.setScale(n,BigDecimal.ROUND_HALF_UP).doubleValue();
		return d2;
	}
	
	/**
	 * Double转String精度保留
	 * @param double1
	 * @param len
	 * @return
	 */
	public static String decimal_n(Double double1,String len) {
		String v1 ="%.6f";
		StringBuilder sb =new StringBuilder(v1);
		String v2 =sb.replace(2,3, len).toString();
		String Nstr = String.format(v2, double1);
		return Nstr;
	}
	
	//D2S保留精度
	public static String D2S(Double dob) {
		Double dbNumberF=new Double(dob);
		NumberFormat numberFormat=java.text.NumberFormat.getInstance();
		numberFormat.setGroupingUsed(false);//只保留了3位，也会四舍五入
		String dbNumFstr=numberFormat.format(dbNumberF);
		return dbNumFstr;
	}
}
